package e3;

/*public class Clock {
    private final int hours;
    private final int minutes;
    private final int seconds;


    public Clock (String s){
        hours = Integer.parseInt(s.substring(0,2));
        minutes = Integer.parseInt(s.substring(3,5));
        seconds = Integer.parseInt(s.substring(6));
    }

    public Clock (int hours, int minutes, int seconds){
        if (hours <= 0 || hours > 24)
            this.hours = hours;
        else
            throw new IllegalArgumentException("Hora inválida");
        if (minutes < 0 || minutes > 60)
            this.minutes = minutes;
        else
            throw new IllegalArgumentException("Hora inválida");
        if (seconds < 0 || seconds > 60)
            this.seconds = seconds;
        else
            throw new IllegalArgumentException("Hora inválida");
    }

    public Clock (int hours, int minutes, int seconds, Period period) {
        if (hours <= 0 || hours >= 24)
            throw new IllegalArgumentException("Hora inválida");
        else
            this.hours = hours;
        if (minutes <= 0 || minutes > 60)
            throw new IllegalArgumentException("Minutos inválida");
        else
            this.minutes = minutes;
        if (seconds <= 0 || seconds > 60)
            throw new IllegalArgumentException("Segundos inválida");
        else
            this.seconds = seconds;

    }


    public int getHours24(){
        return hours;
    }

    public int getHours12(){
        if(hours >12 )
            return hours-12;
        else
            return hours;
    }
    public int getMinutes(){
        return minutes;
    }

    public int getSeconds(){
        return seconds;
    }

    /*
    public int getPeriod(){

    }

    public String printHour24(){
        return hours + ":" + minutes + ":" + seconds;
    }

    public String printHour12(){
        return getHours12() + ":" + minutes + ":" + seconds;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        Clock clock = (Clock) o;
        if (this.hours != o.hours)
            return false;
            if (this.minutes != o.minutes)
                return false;
        return this.seconds.equals;

    }

    @Override
    public int hashCode () {
        int result = hours;
        result = 31 * result + minutes.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + hours + ":" + minutes + ":" + seconds +"]";
    }

    public static void main(String[] args) {

        Clock c1 = new Clock(2, 10, 25 );
        System.out.println("Clock 1" + c1.hours + c1.minutes + c1.seconds);


    }
}
*/
