package cinema.util;


import java.util.List;

public class MatchUtil {

    public static <T> T matchObject(T requestObject, List<T> objectList) {
        T matchedRequestObject = null;
        for (T value : objectList) {
            if (value.equals(requestObject)) {
                matchedRequestObject = value;
            }
        }
        return matchedRequestObject;
    }
}