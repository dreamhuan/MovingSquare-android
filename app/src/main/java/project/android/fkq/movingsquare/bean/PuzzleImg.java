package project.android.fkq.movingsquare.bean;

public class PuzzleImg {
    private int imageId;
    private String name;
    private String intro;

    public PuzzleImg(int imageId, String name, String intro) {
        this.imageId = imageId;
        this.name = name;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
