package org.example;

/**
 * Класс контейнера, который позволяет хранить произвольное количество объектов.
 * Контейнер позволяет добавлять, извлекать, выводить и удалять элементы.
 * @param <datatype> тип данных
 * @author Репников Сергей
 */
public class container<datatype> {
    protected datatype data = null;
    protected container<datatype> next = null, nx;

    /**
     * Функция вставки элемента в начало
     * @param dt данные типа datatype
     */
    public void  insertHead(datatype dt) {
        if (dt == null) return;
        if (this.data != null) {
            nx = new container<>();
            nx.data = this.data;
            nx.next = this.next;
            this.next = nx;
        }
        this.data = dt;
    }

    /**
     * Функция вставки элемента в конец
     * @param dt данные типа datatype
     */
    public void insertEnd(datatype dt) {
        if (dt == null) return;
        if (this.data == null)
            this.data = dt;
        else {
            nx = this;
            while (nx.next != null)
                nx = nx.next;
            nx.next = new container<>();
            nx.next.data = dt;
        }
    }

    /**
     * Функция извлечения первого элемента
     */
    public datatype extraction() {
        datatype dt = this.data;
        if (this.next != null) {
            this.data = this.next.data;
            this.next = this.next.next;
        }
        else this.data = null;
        return dt;
    }


    /**
     * Функция удаления из списка
     * @param dt данные типа datatype
     */
    public boolean del(datatype dt) {
        if (dt == null) return false;
        boolean found = false;
        if (this.data == dt) {
            found = true;
            extraction();
        }
        else {
            nx = this;
            container<datatype> prev = nx;
            while (!found && nx.next != null) {
                found = nx.next.data == dt;
                prev = nx;
                nx = nx.next;
            }
            if (found) {
                prev.next = nx.next;
                nx = new container<>();
                nx = null;
            }
        }
        return found;
    }
    /**
     * Метод выведения на экран списка данных
     */
    public void print() {
        nx = this;
            while (nx != null) {
                System.out.print(nx.data + " ");
                nx=nx.next;
            }
    }
}