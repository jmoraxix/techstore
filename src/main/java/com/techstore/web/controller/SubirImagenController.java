package com.techstore.web.controller;

import com.techstore.web.storage.StorageFileNotFoundException;
import com.techstore.web.storage.StorageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Log4j2
@RequestMapping("/admin/subirimagen")
public class SubirImagenController {

	private final StorageService storageService;

	@Autowired
	public SubirImagenController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/")
	public ModelAndView listUploadedFiles(Model model) throws IOException {
		model.addAttribute("files", storageService.loadAll().map(path
				-> MvcUriComponentsBuilder.fromMethodName(SubirImagenController.class,"serveFile",
				path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));
		return new ModelAndView("imagenes/subir-imagen", (Map<String, ?>) model);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/")
	public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
		storageService.store(file);
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		return new ModelAndView("redirect:/admin/subirimagen/");
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
