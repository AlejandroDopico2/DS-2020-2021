package e4;

public enum Color {
        GREEN( 15),
        AMBERB( 5),
        AMBERNB(5),
        RED( 0);


        private final int tiempo;

        Color( int tiempo){
            this.tiempo=tiempo;
        }

        public int getTiempo(){ return tiempo; }
}
