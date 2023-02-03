package Utilities;

import java.util.List;

public class IntegerListOperationUtil {

    public class ListManipulatorImpl implements IntegerListOperation {
        @Override
        public void manipulateList(List<int[]> list) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i)[0] == list.get(j)[0]) {
                        list.get(i)[1] += list.get(j)[1];
                        list.remove(j);
                    }
                }
            }
        }
    }
}
