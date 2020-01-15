package io.github.atmaramnaik.kosel.web

class PageProvider<BaseApp: WebApp<BaseApp>>(val app:BaseApp){
    infix inline fun <reified T: WebPage<BaseApp>> after(block:()->Unit): T {
        block()
        return app.page()
    }
}