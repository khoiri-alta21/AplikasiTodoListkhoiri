public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        viewShowTodoList();
    }

    //**Menampilkan todolist**//
    public static void showTodoList() {
        System.out.println("TODOLIST ABSENSI MATA KULIAH PEMOGRAMAN BERORIENTASI OBJEK");
        System.out.println("-------------------");
        for (var i = 0; i < model.length; i++) {
            String todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    //Testing
    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Studi Kasus : Membuat Aplikasi Todolist";
        showTodoList();
    }

    //**Menambah todolist**//
    public static void addTodoList(String todo) {
        // cek apakah data penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                //**Model masiih ada yang kosong**//
                break;
            }
        }

        //**Jika penuh kita resize array**//
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i =  0; i < model.length; i++) {
                model[i] = temp[i];
            }
        }

        //**Tambahkan posisi ke data null**//
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public  static void testAddTodoList() {
        for (int i = 0; i < model.length; i++) {
            addTodoList("Contoh todo ke." + i);
        }

        showTodoList();
    }

    //**Menghapus Todolist **//
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return  false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model [i] = model[i + 1];
                }
            }

            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }




    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var prodi = input("Jurusan");
        System.out.println(prodi);
    }


    public static void viewShowTodoList() {
        while (true) {
            showTodoList();
            System.out.println("Pilih Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("x. Keluar");
            System.out.println("-------------------");


            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan Tidak Dimengerti");
                System.out.println("-------------------");
            }
        }

    }

    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }


    //**Menampilkan view todolist**//
    public static void viewAddTodoList() {
        System.out.println("Silahkkan Menambahkan Data Todolist");
        var todo = input("Todo(Ketik x Jika Batal");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();
        showTodoList();
    }

    public static void viewRemoveTodoList() {
        System.out.println("Silahkkan Menghapus Data Todolist");
        var number = input("Nomor yang dihapus(x Jika Batal");

        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal Menghapus Dari Todolist: " + number);
            }
        }

    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }

}
