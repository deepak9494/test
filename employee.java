public class Employee {
    private Long id;
    private String name;
    private String currentProject;
    private String location;

    public Employee() {}

    public Employee(Long id, String name, String currentProject, String location) {
        this.id = id;
        this.name = name;
        this.currentProject = currentProject;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCurrentProject() { return currentProject; }
    public void setCurrentProject(String currentProject) { this.currentProject = currentProject; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
