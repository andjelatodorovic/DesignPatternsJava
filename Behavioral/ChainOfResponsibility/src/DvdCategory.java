public class DvdCategory implements TopTitle {  
   private String category; 
   private String topCategoryTitle;
    
   public DvdCategory(String category) {
        this.setCategory(category);
   }    
   
   public void setCategory(String categoryIn) {
       this.category = categoryIn;
   }
   public String getCategory() {
       return this.category;
   } 
   public String getAllCategories() {
       return getCategory();
   }
   
   public void setTopCategoryTitle(String topCategoryTitleIn) {
       this.topCategoryTitle = topCategoryTitleIn;
   }
   public String getTopCategoryTitle() {
       return this.topCategoryTitle;
   }
   
   public String getTopTitle() {
       return this.topCategoryTitle;
   }
}
