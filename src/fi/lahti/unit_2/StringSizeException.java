package fi.lahti.unit_2;

public class StringSizeException {


    public void StringException(String[][] arr) throws MyArraySizeException {

        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new MyArraySizeException(String.format("Неверное количество столбцов в %d-й" + " строке", i + 1));
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public void isParsable(String[][] arr) throws MyArrayDataException{
        int summa = 0;
        int a = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        summa += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException ex) {
                        throw new MyArrayDataException(i, j);
                    }


                }
            }
            System.out.println(summa);

        }

    }






