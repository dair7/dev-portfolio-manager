package com.dair.portfolio.dto.projectDTO;

import lombok.Data;
import java.util.List;

@Data
public class ProjectResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String githubUrl;
    private String demoUrl;
    private String imageUrl;
    private String categoryName;
    private List<String> technologyNames;
}
