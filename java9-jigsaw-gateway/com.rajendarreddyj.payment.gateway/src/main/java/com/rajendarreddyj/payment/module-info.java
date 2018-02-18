module com.rajendarreddyj.payment.gateway {
    exports com.rajendarreddyj.payment.gateway.api;
    exports com.rajendarreddyj.payment.gateway.factory;

    requires transitive com.rajendarreddyj.bank.api;
}