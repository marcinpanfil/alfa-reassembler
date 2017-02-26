package fragment.submissions.reassemble
/**
 * Created by Marcin Panfil on 26.02.17.
 */
class TestString {

    public static String INPUT = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci " +
            "velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem " +
            "ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia " +
            "dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat " +
            "voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem " +
            "ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut " +
            "labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us " +
            "modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi " +
            "tem;pora inc;am al"

    public static String OUTPUT = "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, " +
            "consectetur, adipisci velit, sed quia non numquam eius modi tempora " +
            "incidunt ut labore et dolore magnam aliquam quaerat voluptatem."

    public static String FIRST_STEP = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci " +
            "velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem " +
            "ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia " +
            "dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat " +
            "voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem " +
            "ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numqua;unt ut " +
            "labore et dolore magnam aliquam qu;us " +
            "modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi " +
            "tem;pora inc;am al"

    public static String SECOND_STEP = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci " +
            "velit;olore magnam aliqua;idunt ut labore et dolore magnam aliquam qu;uptatem.;i dolorem " +
            "ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia " +
            "dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat " +
            "voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem " +
            "ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numqua;us " +
            "modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi " +
            "tem;pora inc;am al"

    public static String THIRD_STEP = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci " +
            "velit;olore magnam aliqua;idunt ut labore et dolore magnam aliquam qu;uptatem.;i dolorem " +
            "ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia " +
            "dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qui dolorem i;aerat " +
            "voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem " +
            "ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numqua;us " +
            "modi tempora incid;uam eius modi tem;pora inc;am al"

    public static String FOURTH_STEP = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci " +
            "velit;olore magnam aliqua;idunt ut labore et dolore magnam aliquam qu;uptatem.;i dolorem " +
            "ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;" + "" +
            "squam est, qui do;Neque porro quisquam est, qui dolorem i;aerat " +
            "voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem " +
            "ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numqua;us " +
            "modi tempora incid;uam eius modi tem;pora inc;am al"

}
