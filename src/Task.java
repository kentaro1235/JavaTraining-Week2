import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private LocalDate deadline;
    private boolean isCompleted;

    public Task(String title, LocalDate deadline){
        this.title = title;
        this.deadline = deadline;
        this.isCompleted = false;
    } //タスク情報
    
//ゲッター
public String getTitle(){
    return title;
}
public LocalDate getDeadline(){
    return deadline;
}
public boolean getIsCompleted(){
    return isCompleted;
}
public void complete(){
    this.isCompleted = true;
}

@Override
public String toString(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String status = isCompleted ? "[完了]" : "[未完了]";
    return status + "タイトル：　" + title + "/ 期限:　" + deadline.format(formatter);
} //表示

}
