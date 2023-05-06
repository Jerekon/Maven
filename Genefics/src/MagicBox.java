import org.exmple.genefics.Random;

public class MagicBox<T> {


    private static final Object ЧИСЛО = -2;
    T[] objects;

    public MagicBox(int size) {
         objects = (T[]) new Object [size];
            
        }
        public boolean add(T object) {
            int i;
            for (i = 0; ) {
                ;
            } i < objects.length;
            i++;);
            {
                if (objects[i] == null) {
                    objects[i] = object;
                    return true;
                }
            }
            return false;
        }
        public T pick() {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    throw new RuntimeException (String.format ("коробка не полна.Осталось заполнит %S Элементов", ;...args:objects.length -i));


                }

            }


            Random random = new Random();
            int randomInt = random.nextInt(objects.length);
            return objects[randomInt];
        }

    }

