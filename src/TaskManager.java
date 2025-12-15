import java.util.ArrayList;
import java.util.stream.IntStream;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    //タスクを追加
    public void addTask(Task task){
        tasks.add(task);  //ArrayList　tasksにユーザーが指定したタスク情報を追加
        System.out.println("タスクを追加しました"); 
    }
    //タスク一覧の表示
    public void showTasks(){
        if(tasks.isEmpty()){
            System.out.println("まだ何も登録されていません"); 
            return;
        } //空のとき
        System.out.println("ータスク一覧ー");
        IntStream.range(0, tasks.size())
         .forEach(i -> System.out.println((i + 1) + ": " + tasks.get(i)));
    }
    //タスクを削除
    public void removeTask(int TaskNumber){
        if(TaskNumber < 1 || TaskNumber > tasks.size()){
            System.out.println("無効な番号です"); 
        } //無効な値が入力されたときの処理
        else{
            Task removed = tasks.remove(TaskNumber-1);
            System.out.println(removed.getTitle() + "を削除しました"); 
        } //タスク情報の削除
    }
    //タスクを完了
    public void completeTask(int TaskNumber){
        try{
            tasks.get(TaskNumber-1).complete();
            System.out.println("タスクを完了にしました");
        } catch(IndexOutOfBoundsException e){
            System.out.println("その番号のタスクは存在しません");
        } //無効な値が入力されたときの処理
    }

    //タスク件数の表示
    public int countTask(){
        return tasks.size();
    }
  
}
