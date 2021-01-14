package models;

public class PetAddRequest {
    public int id;
    public Category category;
    public String name;
    public String[] photoUrls;
    public Tags[] tags;
    public String status;
    public String[] rules;

    public PetAddRequest(int id, String name, String[] rules) {
        this.id = id;
        this.category = new Category(22,"Good Dogs");
        this.name = name;
        this.photoUrls = new String[]{"sss/ddd", "sdsds"};
        this.status = "available";
        this.rules = rules;
        this.tags = new Tags[]{(new Tags(45,"Dvornik")), (new Tags(55,"iiii")),(new Tags(65,"llll"))};

    }
}
