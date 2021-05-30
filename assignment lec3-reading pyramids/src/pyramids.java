public class pyramids {
 private String modern_name , pharoe, site;
 private double hieght;
 public pyramids(String mn, String ph , String site, double hieght){

     this.modern_name=mn;
     this.pharoe=ph;
     this.site=site;
     this.hieght=hieght;
 }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public String getPharoe() {
        return pharoe;
    }

    public void setPharoe(String pharoe) {
        this.pharoe = pharoe;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public double getHieght() {
        return hieght;
    }

    public void setHieght(double hieght) {
        this.hieght = hieght;
    }
    @Override
    public String toString() {
        return String.format(pharoe+" "+modern_name+" "+site+" "+hieght);
    }
}
