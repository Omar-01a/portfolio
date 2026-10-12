package com.omar.portfolio.controller;
 import java.util.List; 
 import org.springframework.http.ResponseEntity;
  import org.springframework.web.bind.annotation.CrossOrigin;
   import org.springframework.web.bind.annotation.DeleteMapping; 
   import org.springframework.web.bind.annotation.GetMapping; 
   import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping; 
   import org.springframework.web.bind.annotation.RequestBody;
     import org.springframework.web.bind.annotation.RequestMapping;
      import org.springframework.web.bind.annotation.RestController;
       import com.omar.portfolio.dto.ProjectRequest; 
       import com.omar.portfolio.entity.Project; 
       import com.omar.portfolio.service.ProjectService; 
       import jakarta.validation.Valid;
        @RestController
         @RequestMapping
         ("/api/projects")
          @CrossOrigin(origins = "http://localhost:5173") 
          public class ProjectController
           { 
            private final ProjectService
             projectService;
              public ProjectController(ProjectService projectService)
               { 
                this.projectService = projectService;
             }
              @GetMapping public List<Project> getAllProjects() 
              { 
                return projectService.getAllProjects(); 
            } 
            @GetMapping("/{id}")
public ResponseEntity<Project> getProjectById(@PathVariable Long id) {

    return ResponseEntity.ok(
            projectService.getProjectById(id)
    );
}
                
                @PostMapping public Project createProject(@Valid @RequestBody ProjectRequest request)
                 {
                     return projectService.createProject(request);

                 }
                  @PutMapping("/{id}")
                   public Project updateProject
                   ( @PathVariable Long id, @RequestBody Project project)
                    {
                         return projectService.updateProject(id, project); 
                        }
                    
                   
                   @DeleteMapping("/{id}")
                     public ResponseEntity<Void> deleteProject( @PathVariable Long id) 
                        { projectService.deleteProject(id); 
                            return ResponseEntity.noContent().build(); 
                        } 
                    
                    }