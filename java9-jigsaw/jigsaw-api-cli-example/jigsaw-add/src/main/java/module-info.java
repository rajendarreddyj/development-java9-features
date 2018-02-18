module com.rajendarreddyj.jigsaw.calculator.add {
    requires com.rajendarreddyj.jigsaw.calculator.api;

    provides com.rajendarreddyj.jigsaw.calculator.api.Algorithm with com.rajendarreddyj.jigsaw.calculator.api.add.impl
            .Add;
}
