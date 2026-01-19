// Polimorfisme: Override, Upcasting, Downcasting Aman (instanceof)

// ABSTRACT CLASS (superclass)
abstract class Media {
    abstract void play(); // akan dioverride
}

// CLASS TURUNAN (subclass)
class Song extends Media {
    @Override
    void play() {
        System.out.println("Playing song...");
    }

    void setEqualizer(int level) {
        System.out.println("Equalizer set to level: " + level);
    }
}

class Video extends Media {
    @Override
    void play() {
        System.out.println("Playing video...");
    }

    void setSubtitle(boolean on) {
        System.out.println("Subtitle: " + (on ? "ON" : "OFF"));
    }
}

class Podcast extends Media {
    @Override
    void play() {
        System.out.println("Playing podcast...");
    }

    void setSpeed(double s) {
        System.out.println("Playback speed set to: " + s + "x");
    }
}

// MAIN PROGRAM
public class Main5 {
    public static void main(String[] args) {

        // =======================
        // Upcasting → semua objek dianggap Media
        // =======================
        Media[] playlist = {
            new Song(),
            new Video(),
            new Podcast(),
            new Song()
        };

        // =======================
        // 1. Polimorfisme → panggil play() sesuai object asli
        // =======================
        System.out.println("===== PLAYLIST =====");
        for (Media m : playlist) {
            m.play(); // polymorphism (runtime binding)
        }

        System.out.println("\n===== FITUR KHUSUS (Downcasting Aman) =====");
        
        // =======================
        // 2. Downcasting aman pakai instanceof
        // =======================
        for (Media m : playlist) {

            // Jika object Song
            if (m instanceof Song) {
                Song s = (Song) m; // downcast aman
                s.setEqualizer(8);
            }

            // Jika object Video
            else if (m instanceof Video) {
                Video v = (Video) m; // downcast aman
                v.setSubtitle(true);
            }

            // Jika object Podcast
            else if (m instanceof Podcast) {
                Podcast p = (Podcast) m; // downcast aman
                p.setSpeed(1.5);
            }
        }

        System.out.println("\n===== DONE =====");
    }
}
