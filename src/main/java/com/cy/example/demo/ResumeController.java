package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ResumeController {

    @Autowired
    CoverletterRepository coverletterRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    ReferenceRepository referenceRepository;

    @Autowired
    SummaryRepository summaryRepository;




    @RequestMapping("/cover")
    public String listCover(Model model) {
        model.addAttribute("covers", coverletterRepository.findAll());
        return "listcover";
    }

    @RequestMapping("/resume")
    public String listResume(Model model){
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("summaries", summaryRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("experiences", experienceRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("references", referenceRepository.findAll());
        return "listresume";
    }

    @GetMapping("/addcover")
    public String contactForm(Model model){
        model.addAttribute("coverletter", new Coverletter());
        return "coverpage";
    };

    @GetMapping("/addcontact")
    public String rcontactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "contactpage";
    };

    @GetMapping("/addsumm")
    public String summaryForm(Model model){
        model.addAttribute("summary", new Summary());
        return "summarypage";
    };

    @RequestMapping("/addedu")
    public String educationForm(Model model){
        model.addAttribute("education", new Education());
        return "educationpage";
    };

    @RequestMapping("/addexp")
    public String experienceForm(Model model){
        model.addAttribute("experience", new Experience());
        return "experiencepage";
    };

    @RequestMapping("/addskills")
    public String skillsForm(Model model){
        model.addAttribute("skill", new Skill());
        return "skillpage";
    };

    @RequestMapping("/addreference")
    public String referenceForm(Model model){
        model.addAttribute("reference", new Reference());
        return "referencepage";
    };


    @PostMapping("/processcover")
    public String processForm(@Valid Coverletter coverletter, BindingResult result)
    {
        if (result.hasErrors()){
            return "coverpage";
        }
        coverletterRepository.save(coverletter);

        return "redirect:/";
    }


    @PostMapping("/processcontact")
    public String processForm(@Valid Contact contact, BindingResult result)
    {
        if (result.hasErrors()){
            return "contactpage";
        }
        contactRepository.save(contact);

        return "redirect:/";
    }

    @PostMapping("/processsummary")
    public String processForm(@Valid Summary summary, BindingResult result)
    {
        if (result.hasErrors()){
            return "summarypage";
        }
        summaryRepository.save(summary);

        return "redirect:/";
    }

    @PostMapping("/processedu")
    public String processForm(@Valid Education education, BindingResult result)
    {
        if (result.hasErrors()){
            return "educationpage";
        }
        educationRepository.save(education);

        return "redirect:/";
    }

    @PostMapping("/processexp")
    public String processForm(@Valid Experience experience, BindingResult result)
    {
        if (result.hasErrors()){
            return "experiencepage";
        }
        experienceRepository.save(experience);

        return "redirect:/";
    }

    @PostMapping("/processski")
    public String processForm(@Valid Skill skill, BindingResult result)
    {
        if (result.hasErrors()){
            return "skillpage";
        }
        skillRepository.save(skill);

        return "redirect:/";
    }

    @PostMapping("/processreference")
    public String processForm(@Valid Reference reference, BindingResult result)
    {
        if (result.hasErrors()){
            return "referencepage";
        }
        referenceRepository.save(reference);

        return "redirect:/";
    }


}
