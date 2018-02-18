module com.rajendarreddyj.jigsaw.calculator.subtract {
    requires com.rajendarreddyj.jigsaw.calculator.api;
    provides com.rajendarreddyj.jigsaw.calculator.api.Algorithm with com.rajendarreddyj.jigsaw.calculator.api
            .subtract.impl.Subtract;
}
