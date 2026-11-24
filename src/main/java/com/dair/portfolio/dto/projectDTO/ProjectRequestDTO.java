package com.dair.portfolio.dto.projectDTO;

import lombok.Data;
import java.util.List;

@Data
public class ProjectRequestDTO {

    private String name;
    private String description;
    private String githubUrl;
    private String demoUrl;
    private String imageUrl;
    private Long categoryId;
    private List<Long> technologyIds;
}
