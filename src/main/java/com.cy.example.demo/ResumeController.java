package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
public class ResumeController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

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

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    OrganizationRepository organizationRepository;

   // @Autowired
   // RequiredskillRepository requiredskillRepository;

    @RequestMapping("/navpage")
    public String navpage(Model model) {
        return "navpage";
    }

    public void createUsers() {

        User user = new User();
        user.setUsername("applicant");
        user.setPassword("password");
        user.setId(1);

        Role role = new Role();
        role.setRole("APPLICANT");

        Collection<Role>  list = Arrays.asList(role);
        user.setRoles(list);


        User user2 = new User();
        user2.setUsername("employer");
        user2.setPassword("password");
        user.setId(2);

        Role role2 = new Role();
        role2.setRole("EMPLOYER");

        Collection<Role>  list2 = Arrays.asList(role2);
        user2.setRoles(list2);

        userRepository.save(user);
        userRepository.save(user2);

        return;
    }



    @RequestMapping("/")
    public String mainpage(Model model) {
        return "mainpage";
    }

    @RequestMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processUser(@Valid User user, BindingResult result)
    {
        if (result.hasErrors()){
            return "registration";
        }
        userService.saveApplicant(user);
        return "redirect:/";

    }

    @RequestMapping("/registeremp")
    public String registerEmp(Model model) {
        model.addAttribute("user", new User());
        return "registrationemp";
    }

    @PostMapping("/registeremp")
    public String processEmp(@Valid User user, BindingResult result)
    {
        if (result.hasErrors()){
            return "registrationemp";
        }
        userService.saveEmployer(user);
        return "redirect:/";

    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String secure(){
        return "mainpage";
    }

    @RequestMapping("/showview")
    public String showcovernresume(Model model) {
         return "viewpage";
    }

    @RequestMapping("/searchbyorg")
    public String searchjobbyorg(Model model){
        return "searchbyorgform";
    }

  /*  @PostMapping("/searchbyorg")
    public String searchbyorg(HttpServletRequest request, Model model){
        String searchString = request.getParameter("organization");
        System.out.println("searchString is " + searchString);
        model.addAttribute("organization",searchString);
        model.addAttribute("jobs", jobRepository.findByOrganization(searchString));
        return "listjob";
    }
    */

    /*
    @RequestMapping("/matchskilljobs")
    public String matchskilljobs(Model model)
    {
      List <Requiredskill> requiredskills = requiredskillRepository.findAll();
      List<Requiredskill> findBySkillname(String skillname) ;

        List <Skill> skills = skillRepository.findAll();
        for (Skill skill: skills) {
            if (skill.getSkillname() = )
        }
        return "matchskilllist";
    }
    */



    @RequestMapping("/showcover")
    public String showcover(Model model) {
        return "coverpage";
    }

    @RequestMapping("/showresume")
    public String showresume(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("summaries", summaryRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("experiences", experienceRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("references", referenceRepository.findAll());
        return "finalresume";
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

    @RequestMapping("/addcover")
    public String coverForm(Model model){
        model.addAttribute("coverletter", new Coverletter());
        return "coverpage";
    };

    @RequestMapping("/addcontact")
    public String contactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "contactpage";
    };

    @PostMapping("/processcontact")
    public String processForm(@Valid @ModelAttribute("contact") Contact contact,Model model, BindingResult result)
    {
        if (result.hasErrors()){
            return "contactpage";
        }
        contactRepository.save(contact);
        model.addAttribute("contact",contactRepository.findAll());

        return "redirect:/";
       // return "contactpage";
    }

    @RequestMapping("/addsumm")
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

    @GetMapping("/update/contact/{id}")
    public String updateContact(@PathVariable("id") long id, Model model) {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contactpage";
    }

    @GetMapping("/update/summary/{id}")
    public String updateSummary(@PathVariable("id") long id, Model model) {
        model.addAttribute("summary", summaryRepository.findOne(id));
        return "summarypage";
    }

    @GetMapping("/update/education/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model) {
        model.addAttribute("education", educationRepository.findOne(id));
        return "educationpage";
    }

    @GetMapping("/update/experience/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model) {
        model.addAttribute("experience", experienceRepository.findOne(id));
        return "experiencepage";
    }

    @GetMapping("/update/skill/{id}")
    public String updateSkill(@PathVariable("id") long id, Model model) {
        model.addAttribute("skill", skillRepository.findOne(id));
        return "skillpage";
    }

    @GetMapping("/update/reference/{id}")
    public String updateReference(@PathVariable("id") long id, Model model) {
        model.addAttribute("reference", referenceRepository.findOne(id));
        return "referencepage";
    }

    @PostMapping("/processcover")
    public String processForm(@Valid Coverletter coverletter, BindingResult result)
    {
        if (result.hasErrors()){
            return "coverpage";
        }
        coverletterRepository.save(coverletter);

        //return "redirect:/";
        return "navpage";
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

    @RequestMapping("/addjob")
    public String addjobForm(Model model){
        model.addAttribute("organizations", organizationRepository.findAll());
        model.addAttribute("job", new Job());
        return "jobpage";
    };

    @RequestMapping("/update/job/{id}")
    public String updatejobForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        model.addAttribute("job",  jobRepository.findOne(id));
        return "jobpage";
    }

    @PostMapping("/processjob")
    public String processjobForm(@Valid Job job, BindingResult result)
    {
        if (result.hasErrors()){
            return "jobpage";
        }
        jobRepository.save(job);
        return "redirect:/";
    }





   /* @PostMapping("/processreqskill/job/{job_id}")
    public String processreqskillForm(@PathVariable("job_id") long id, Requiredskill requiredSkill, BindingResult result, Model model)
    {
        if (result.hasErrors()){
            return "reqskillpage";
        }
        requiredskillRepository.save(requiredSkill);

  /*
        Job job = new Job();
        job.setId(id);
        model.addAttribute("reqskillList", requiredskillRepository.findAll());

      System.out.println("skillid= " + requiredSkill.getId()); */


    /*

        Set<Job> jobs = requiredSkill.getJobs();
        Iterator itr = jobs.iterator();
        while(itr.hasNext()) {
            Job j = (Job) itr.next();
            System.out.println("job_id of this skill " + j.getId());
        }

            System.out.println("skill= " + requiredSkill.getSkillname());

        return "redirect:/";

    }


    @GetMapping("/update/reqskill/{id}")
    public String updatereqSkill(@PathVariable("id") long id, Model model) {
        model.addAttribute("reqskill", requiredskillRepository.findOne(id));
        return "reqskillpage";
    }
    */

    @RequestMapping("/listjob")
    public String listjob(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "listjob";
    }

    @PostMapping("/addskilltojob")
    public String addSkillstoJob(HttpServletRequest request, Model model)
    {
        System.out.println("Entering addskilltojob" );
        String jobid = request.getParameter("jobid");

        Job tjob = jobRepository.findOne(new Long(jobid));
        System.out.println ("tjob info = " + tjob.getPosition() + " " + tjob.getDuties() );

        model.addAttribute("foundjob",jobRepository.findOne(new Long(jobid)));

        //Make skills disappear from add form when they are already included (Set already makes it impossible to add multiple)
        model.addAttribute("skillList",skillRepository.findAll());
        System.out.println("Job id from add skill to job:"+ jobid);
        return "addskilltojob";
    }

    @PostMapping("/saveskilltojob")
    public String saveSkilltoJob(HttpServletRequest request, @ModelAttribute("foundjob") Job job)
    {
        System.out.println("Entering saveskilltojob" );
        String skillid = request.getParameter("skillid");
        System.out.println("Job id from add skill to job:"+job.getId()+" Skill id:"+skillid);
        job.addSkilltoJob(skillRepository.findOne(new Long(skillid)));
        jobRepository.save(job);
        //return "redirect:/listjob";
        return "listjob";
    }

}
