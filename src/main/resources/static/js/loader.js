const scoretool_domain = "https://localhost:13579";

var h = window.location.href;
var lang = navigator.language || navigator.systemLanguage;
if(lang=='ko' || lang=='ko-kr' || lang=='ko-KR') {
   lang = 'ko';
}
else {
  lang = 'ja';
}
var text = {
  not_mainpage: {
    "ko": "MUSECA 1+1/2 공식 사이트에서 실행되지 않았습니다.\nMUSECA 1+1/2 공식 사이트로 이동할까요?",
    "ja": "MUSECA 1+1/2の公式サイトを開いた状態で実行してください。\nMUSECA 1+1/2の公式サイトにジャンプしますか？"
  },
  browser_error: {
    "ko": "본 스코어 툴은 사용중이신 브라우저에서는 대응되지 않습니다.",
    "ja": "このブラウザは対応していません。"
  },
  local_error: {
    "ko": "임시 데이터 저장에 실패하였습니다.",
    "ja": "データの保存が無効になっています。"
  }
};
console.log("run at " + h);
if(!h.match(/\/\/p\.eagate\.573\.jp\/game\/museca\/msc_1half/)){
    if (confirm(text.not_mainpage[lang])) {
        var url = "//p.eagate.573.jp/game/museca/msc_1half/top/index.html";
        location.href = url;
    }
    delete scoretool_domain;
}
else if (typeof localStorage === "undefined" || localStorage === null) {
    window.alert(text.browser_error[lang]);
    delete scoretool_domain;
}
else {
    var isLocalStorageEnabled = false;
    try {
        var test = "test" + Math.random();
        localStorage.setItem("test", test);
        var value = localStorage.getItem("test");
        localStorage.removeItem("test");
        if (test === value) {
            isLocalStorageEnabled = true;
        }
    }
    catch (e) {}

    if (isLocalStorageEnabled) {
        var loadJs = function(src, main){
            var s = document.createElement("script");
            s.type = "text/javascript";
            s.src = src;
            s.setAttribute("data-main", main);
            s.charset = "UTF-8";
            document.head.appendChild(s);
        };
        loadJs(scoretool_domain + "/js/lib/require.js", scoretool_domain + "/js/bookmarklet.js?ver=" + new Date().getTime());
    }
    else {
        window.alert(text.local_error[lang]);
        delete scoretool_domain;
    }
}
