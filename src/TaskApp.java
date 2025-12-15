import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager TaskManager = new TaskManager();

        while(true){
            System.out.println("ータスク管理アプリー");
            System.out.println("1: タスク登録");
            System.out.println("2: タスク一覧表示");
            System.out.println("3: タスク削除");
            System.out.println("4: タスク完了");
            System.out.println("5: 終了");
            System.out.print("番号を選んでください：");  

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:  
                    System.out.print("タイトルを入力：");
                    String title = scanner.nextLine();
                    if(title.isEmpty()){
                        System.out.println("タイトルは空にできません");
                        break;
                    }
                    try{
                    System.out.print("期限をを入力（例： 2025-01-01）：");
                    String deadlineinp = scanner.nextLine();
                    LocalDate deadline = LocalDate.parse(deadlineinp);
                    TaskManager.addTask(new Task(title, deadline)); //タスク登録
                    } catch(DateTimeParseException e){
                        System.out.println("日付の形式が正しくありません");//例外処理
                    }
                    break;

                case 2:  
                    TaskManager.showTasks(); //タスク一覧を表示
                    break;
                
                case 3:
                    System.out.println("削除する書籍の番号を入力：");
                    try{
                    int removetasknumber = Integer.parseInt(scanner.nextLine());
                    TaskManager.removeTask(removetasknumber); //タスクを削除
                    } catch(NumberFormatException e){
                        System.out.println("有効な数字を入力してください");//例外処理
                    }
                    break;
                
                 case 4:
                     System.out.println("完了にするタスクの番号を入力：");
                    try{
                    int comptasknumber = Integer.parseInt(scanner.nextLine());
                    TaskManager.completeTask(comptasknumber); //タスクを完了
                    } catch(NumberFormatException e){
                        System.out.println("有効な数字を入力してください");//例外処理
                    }
                    break;
                
                case 5:
                    System.out.println("終了します。");
                    System.out.println("登録タスク件数： " + TaskManager.countTask() + "件");
                    scanner.close();
                    return;

                default:
                    System.out.println("無効な入力です"); 
                }
            




        }

        
    }
    
}
