package com.agenda.Controller;



import com.agenda.service.ContactsService;
import com.agenda.domain.Contactos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Slf4j
@Controller
@RequestMapping("/contacts")
public class ContactsController {


    @Autowired
    private ContactsService contactsService;


    @GetMapping(path = "/list")
    public String  list(Model model){
        try {
            model.addAttribute("titulo","Lista de contactos");
            model.addAttribute("contactos",contactsService.list());
        }catch (Exception exc){
          log.info(String.valueOf(exc));
        }
        return "views/contactos/listar";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) throws IOException {
        Contactos c = new Contactos();
        c = contactsService.findById(id).get();
        contactsService.save(c);
        model.addAttribute("titulo","Actualizando Contacto");
        model.addAttribute("contacto",c);
        return "views/contactos/editar";
    }

    @PostMapping(path = "/update")
    public String update(Contactos contacto,RedirectAttributes redirectAttributes) throws IOException {
        contactsService.update(contacto.getId(),contacto);
        redirectAttributes.addFlashAttribute("success",
                "Contacto actualizado con exito");
        return "redirect:/contacts/list";
    }

    @GetMapping("/create")
    public String create() {
        return "views/contactos/crear";
    }

    @RequestMapping(path = "/save", method = POST)
    public String save(Contactos contacto,  RedirectAttributes redirectAttributes) throws IOException {
        contactsService.save(contacto);

        redirectAttributes.addFlashAttribute("success",
                "Contacto creado con exito");
        return "redirect:/contacts/list";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,RedirectAttributes redirectAttributes){
        Contactos c = new Contactos();
        c = contactsService.getById(id).get();
        contactsService.delete(c);
        redirectAttributes.addFlashAttribute("success",
                "Contacto eliminado con exito");
        return "redirect:/contacts/list";
    }
}