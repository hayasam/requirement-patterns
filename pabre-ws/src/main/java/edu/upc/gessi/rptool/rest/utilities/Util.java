package edu.upc.gessi.rptool.rest.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class Util {

    private Util() {
        //utility class
    }

    /**
     * Convert a Collection to a list
     * 
     * @param c
     * @return
     */
    public static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
	List<T> list = new ArrayList<>(c);
	java.util.Collections.sort(list);
	return list;
    }

    public static <T> List<T> uniqueList(Collection<T> c) {
	LinkedHashSet<T> t = new LinkedHashSet<>(c);
	return new ArrayList<>(t);
    }

}
