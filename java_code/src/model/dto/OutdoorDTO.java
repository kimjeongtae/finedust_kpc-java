package model.dto;

public class OutdoorDTO{
   private String festival_name;
   private String period;   
   private String loc;   
   private String home;
   private String inform;
   private String i1;
   private String i2;
   private String i3;
   
   
   public OutdoorDTO(String festival_name, String period, String loc, String home, String inform, String i1, String i2, String i3) {
      this.festival_name = festival_name;
      this.period = period;
      this.loc = loc;
      this.home = home;
      this.inform = inform;
      this.i1 = i1;
      this.i2 = i2;
      this.i3 = i3;
   }


   public String getFestival_name() {
      return festival_name;
   }


   public void setFestival_name(String festival_name) {
      this.festival_name = festival_name;
   }


   public String getPeriod() {
      return period;
   }


   public void setPeriod(String period) {
      this.period = period;
   }


   public String getLoc() {
      return loc;
   }


   public void setLoc(String loc) {
      this.loc = loc;
   }


   public String getHome() {
      return home;
   }


   public void setHome(String home) {
      this.home = home;
   }


   public String getInform() {
      return inform;
   }


   public void setInform(String inform) {
      this.inform = inform;
   }


   public String getI1() {
      return i1;
   }


   public void setI1(String i1) {
      this.i1 = i1;
   }


   public String getI2() {
      return i2;
   }


   public void setI2(String i2) {
      this.i2 = i2;
   }


   public String getI3() {
      return i3;
   }


   public void setI3(String i3) {
      this.i3 = i3;
   }


   public OutdoorDTO() {
   }


   @Override
   public String toString() {
      return "OutdoorDTO [festival_name=" + festival_name + ", period=" + period + ", loc=" + loc + ", home=" + home
            + ", inform=" + inform + ", i1=" + i1 + ", i2=" + i2 + ", i3=" + i3 + "]";
   }
}