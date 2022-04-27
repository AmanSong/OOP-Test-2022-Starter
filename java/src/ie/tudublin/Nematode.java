package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode 
{
    //fields
    private String name;
    private Integer length;
    private Integer limbs;
    private String gender;
    private Integer eyes;

    //toString method
    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    //TableRow constructor
    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"),
            tr.getInt("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getInt("eyes")
        );
    }

    //constructor
    public Nematode(String name, Integer length, Integer limbs, String gender, Integer eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    //accessor 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLimbs() {
        return limbs;
    }

    public void setLimbs(Integer limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEyes() {
        return eyes;
    }

    public void setEyes(Integer eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser nv)
    {
        nv.background(0);

        //prints the name
        nv.textAlign(PApplet.CENTER);
        nv.textSize(25);
        nv.text(name, nv.width/2, nv.height/4);

        int segements = length;
        nv.stroke(255);
        nv.noFill();
        for(int i = 0; i < segements; i++)
        {
            float y = PApplet.map(i, 0, length, 300, nv.height-250);
            nv.circle(nv.width/2, y, 50);

            if(limbs == 1)
            {
                nv.line(nv.width/2.3f, y, nv.width/2.13f, y);
                nv.line(nv.width/1.88f, y, nv.width/1.75f, y);
            }
        }


    }

}
