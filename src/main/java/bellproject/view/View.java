package bellproject.view;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class View {

    public boolean filter(View view) {

        return Stream.of(view.getClass().getDeclaredFields())
                .filter(field -> {
                    try {
                        return field.get(view) != null && !field.get(view).equals(field.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList())
                .isEmpty();
    }

    public boolean haveNotNullFields(List<String> fields){
        return Stream.of(this.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList()).containsAll(fields);
    }

}
