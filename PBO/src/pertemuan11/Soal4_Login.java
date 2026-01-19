import java.util.Scanner;

// Custom Exception
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class PasswordSalahException extends Exception {
    public PasswordSalahException(String message) {
        super(message);
    }
}

// Program Login
public class Soal4_Login {

    static String USERNAME_BENAR = "ilham";
    static String PASSWORD_BENAR = "1010";

    // Method login
    public static void login(String user, String pass)
            throws UserNotFoundException, PasswordSalahException {

        if (!user.equals(USERNAME_BENAR)) {
            throw new UserNotFoundException("Username tidak ditemukan!");
        }

        if (!pass.equals(PASSWORD_BENAR)) {
            throw new PasswordSalahException("Password salah!");
        }

        System.out.println("Login berhasil! Selamat datang, " + user + "!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan username: ");
            String u = input.nextLine();

            System.out.print("Masukkan password: ");
            String p = input.nextLine();

            try {
                login(u, p);
                break; // keluar loop jika login berhasil
            }
            catch (UserNotFoundException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            catch (PasswordSalahException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            finally {
                System.out.println("Silakan coba lagi.\n");
            }
        }

        System.out.println("Proses login selesai.");
        input.close();
    }
}
