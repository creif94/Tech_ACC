public class Override_Constructors {
    public class Picture {
        private boolean framed;
        private int height;
        private int width;


        Picture(){
            this(false,0,0);
        }

        Picture(int height, int width){
            this(false,height,width);


        }

        Picture(boolean framed, int height, int width) {
            this.framed = framed;
            this.height = height;
            this.width = width;
        }
    }

}
