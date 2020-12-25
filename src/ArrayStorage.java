public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) return i;
        }
        return -1;
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;

        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            System.arraycopy(storage, index+1, storage, index, size-index);
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageNONull = new Resume[size];
        if (size >= 0) System.arraycopy(storage, 0, storageNONull, 0, size);
        return storageNONull;
    }

    int size() {
        return size;
    }
}
