package Logic;
import javafx.scene.paint.Stop;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.TimerTask;
import java.util.Timer;

public class StopWatch extends TimerTask{
    private LocalDateTime currentStopwatch;
    private Boolean isActivated;
    private Timer m_timer = new Timer();

    public StopWatch (){
        currentStopwatch = LocalDateTime.of(0,0,0,0,0,0);
    }
    @Override
    public void run() {
        this.currentStopwatch = this.currentStopwatch.plusSeconds(1);
    }

    public void activate() {
        this.isActivated = true;
        m_timer.schedule(this, 0, 1000);
    }
    public void pause() {
        this.isActivated = false;
        m_timer.cancel();
    }
    public void reset() {
        SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
        if(!this.isActivated) {
            currentStopwatch = LocalDateTime.of(0,0,0,0,0,0);
            this.isActivated = false;
        }
        else
            System.out.println("비활성화 되지 않습니다.");
    }
}