package e3;

public class Clock {
    private final int hours;
    private final int minutes;
    private final int seconds;
    private Period period;
    public enum Period {AM, PM}


    public Clock (String s){
        hours = Integer.parseInt(s.substring(0,2));

        if (hours >= 0 && hours < 24){
            minutes = Integer.parseInt(s.substring(3,5));
            if (minutes >= 0 && minutes < 60){
                seconds = Integer.parseInt(s.substring(6,8));
                if (seconds < 0 || seconds > 60) {
                    throw new IllegalArgumentException("Segundos inválidos");
                }
            } else {
                throw new IllegalArgumentException("Minutos inválidos");
            }
        }else {
            throw new IllegalArgumentException("Hora inválida");
        }

        if (s.length() == 11){
            if (s.charAt(8) == ' '){
                if (s.startsWith("PM", 9)) {
                    period = Period.PM;
                } else if (s.startsWith("AM", 9)) {
                    period = Period.AM;
                } else
                    throw new IllegalArgumentException("Periodo inválido");
            }
        }
    }

    public Clock (int hours, int minutes, int seconds){
        if (hours < 0 || hours >= 24)
            throw new IllegalArgumentException("Hora inválida");
        else
            this.hours = hours;
        if (minutes < 0 || minutes > 60)
            throw new IllegalArgumentException("Minutos inválida");
        else
            this.minutes = minutes;
        if (seconds < 0 || seconds > 60)
            throw new IllegalArgumentException("Segundos inválida");
        else
            this.seconds = seconds;
    }

    public Clock (int hours, int minutes, int seconds, Period period) {
        if (hours < 0 || hours >= 24)
            throw new IllegalArgumentException("Hora inválida");
        else
            this.hours = hours;
        if (minutes < 0 || minutes > 60)
            throw new IllegalArgumentException("Minutos inválida");
        else
            this.minutes = minutes;
        if (seconds < 0 || seconds > 60)
            throw new IllegalArgumentException("Segundos inválida");
        else
            this.seconds = seconds;

        this.period = period;

    }

    public int getHours24(){
        if(period == Period.PM)
            return hours+12;
        else if (period == Period.AM && hours == 12)
            return 0;
        else
            return hours;
    }

    public int getHours12(){
        if(hours > 12 )
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


    public Period getPeriod(){
        if(getHours24() >= 12 )
            period = Period.PM;
        else

            period = Period.AM;

        return  period;
    }

    public String printHour24(){

        String formato = "%02d:%02d:%02d";

        if(period == Period.PM)
            return String.format(formato,hours+12,minutes,seconds);
        else if (period == Period.AM && hours == 12)
            return String.format(formato,0,minutes,seconds);

        else
            return String.format(formato,hours,minutes,seconds);

    }

    public String printHour12(){
        String formato = "%02d:%02d:%02d";

        return String.format(formato,getHours12(),minutes,seconds)+ " " + getPeriod();
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        Clock clock = (Clock) o;
        if (this.getHours24() != clock.getHours24())
            return false;
        if (this.getMinutes() != clock.getMinutes())
            return false;
        return this.getSeconds() == clock.getSeconds();

    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + getHours24();
        result = 31 * result + getMinutes();
        result = 31 * result + getSeconds();
        result = 31 * result + (getPeriod() == null ? 0 : getPeriod().hashCode());
        return result;
    }
}