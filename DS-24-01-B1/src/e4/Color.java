package e4;

public enum Color {
        GREEN( 15),
        AMBER( 5),
        RED( 20);


        private final int tiempo;

        Color( int tiempo){
            this.tiempo=tiempo;
        }

        public int getTiempo(){ return tiempo; }
}
