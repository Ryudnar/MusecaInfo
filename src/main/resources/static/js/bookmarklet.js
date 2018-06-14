var RETRY_MAX = 30;
var LOAD_DELAY = 50;
var NEXT_STEP_DELAY = 1000;
var RETRY_DELAY = 3000;
var TARGET_ENCODING = "Shift_JIS";

// --------------------------------------------------------------------------------

var lang = navigator.language || navigator.systemLanguage;
if(lang=='ko' || lang=='ko-kr' || lang=='ko-KR') {
   lang = 'ko';
}
else {
  lang = 'ja';
}
var text = {
  no_playerdata: {
    "ko": "CURATOR 데이터가 존재하지 않습니다.\ne-amusement에 로그인하신 후에 다시 시도해주세요.",
    "ja": "CURATORデータが見つかりませんでした。\nログインしてから実行してください。"
  },
  playerdata: {
    coloris: {
      "ko": "소지 COLORIS",
      "ja": "所持COLORIS"
    },
    grafica: {
      "ko": "Grafica 소지 수",
      "ja": "Grafica所持数"
    },
    latest_date: {
      "ko": "최근 플레이 시간",
      "ja": "最終プレー日時"
    },
    latest_shop: {
      "ko": "최근 플레이 점포",
      "ja": "最終プレー店舗"
    },
    total_count: {
      "ko": "총 플레이 악곡 수",
      "ja": "楽曲総プレー数"
    }
  },
  playerdata_success: {
    "ko": "<br>CURATOR 정보 취득에 성공하였습니다.<br>1초 후, 곡 리스트 취득을 시작합니다.<br><br>",
    "ja": "<br>CURATOR情報取得に成功しました。<br>1秒後、曲リストの読み込みを始めます。<br><br>"
  },
  load_songlist: {
    "ko": " 페이지 로딩 중...<br>",
    "ja": " ページ目をロード中…<br>"
  },
  songlist_success: {
    "ko": "<br>곡 리스트 정보를 취득하였습니다.<br>1초 후, 곡 상세 정보 취득을 시작합니다.<br><br>",
    "ja": "<br>曲リスト情報取得に成功しました。<br>1秒後、曲詳細情報の読み込みを始めます。<br><br>"
  },
  songdata_load: {
    "ko": "을(를) 읽는 중...<br>",
    "ja": "をロード中…<br>"
  },
  ajax_error: {
    "ko": " 가 발생했습니다.<br>다시 시도해주세요.<br> 동일한 문제가 계속 발생할 경우 관리자(@kwang8e)에게 문의해주시기 바랍니다.",
    "ja": " が発生しました。<br>もう一度やり直してください。<br>同じ問題が発生する場合管理者(@kwang8e)に問い合わせください。"
  }
};

var script = document.createElement("script");
script.setAttribute("src", "//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js");
script.addEventListener('load', function() {
  var script = document.createElement("script");
  document.body.appendChild(script);
}, false);
document.body.appendChild(script); // 개발자도구에서 ajax 테스트용

var div = document.createElement("div");
div.setAttribute("style", "position:absolute; top:150px; left:59%; width:40%; height:70%; overflow:scroll; overflow-x:hidden; z-index: 2147483647; background-color: white");
div.setAttribute("id", "scoreToolScraping");
document.body.appendChild(div);

$.ajaxSetup({
  type: "GET",
  timeout: 2000
});

var songLink = [];
var songDetail = [];
var i = 0; // for iteration
var retryCount = 0;
// var numOfSongPages = 1; // 노래 취득할 페이지 변경할 때 쓸 변수

getPlayerData();

function getPlayerData() {
  $.ajax({
    url: "//p.eagate.573.jp/game/museca/msc_1half/playdata/index.html",
    success: function(data) {
      var $result = $(data);
      if($result.find("#nologin_title").length) {
        alert(text.no_playerdata[lang]);

      }
      else {
        var playerData = {"playerName": null, "playerRank": -0, "playerColoris": 0, "playerGrafica": 0, "playerLatestDate": null, "playerLatestPlace": null, "playerLatestCount": 0};
        $result.find("tr > td").each(function(index){
          switch(index) {
            case 0: playerData.playerName = $(this).text(); break;
            case 1: playerData.playerRank = parseInt($(this).text()); break;
            case 2: playerData.playerColoris = parseInt($(this).text()); break;
            case 3: playerData.playerGrafica = parseInt($(this).text()); break;
            case 4: playerData.playerLatestDate = $(this).text(); break;
            case 5: playerData.playerLatestPlace = $(this).text(); break;
            case 6: playerData.playerLatestCount = parseInt($(this).text()); break;
          }
        });
        console.log(playerData);
        $("#scoreToolScraping").append('<br>CURATOR NAME : ' + playerData.playerName + '<br>' + 'CURATOR RANK : ' + playerData.playerRank + '<br>' + text.playerdata.coloris[lang] + ' : ' + playerData.playerColoris + '<br>' + text.playerdata.grafica[lang] + ' : ' + playerData.playerGrafica + '<br>' + text.playerdata.latest_date[lang] + ' : ' + playerData.playerLatestDate + '<br>' + text.playerdata.latest_shop[lang] + ' : ' + playerData.playerLatestPlace + '<br>' + text.playerdata.total_count[lang] + ' : ' + playerData.playerLatestCount + '<br>');
        $("#scoreToolScraping").append(text.playerdata_success[lang]);
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: "https://localhost:13579/player/save",
            data: JSON.stringify(playerData),
            success: function (result) {
                setTimeout(getSongLink, NEXT_STEP_DELAY);
            }
        });
      }
    },
    error: function(request, status, error){
        if(ajaxError(request, status, error, getPlayerData) === "timeout" && retryCount < RETRY_MAX) {
          $("#scoreToolScraping").append('Response Timeout... ' + (++retryCount) + 'th retry...<br>');
          setTimeout(getPlayerData, RETRY_DELAY);
        }
        else
    }
  });
}

function getSongLink() {
  $.ajax({
    url: "//p.eagate.573.jp/game/museca/msc_1half/playdata/playdata_music.html?page=" + i + "&filter=0&sort_type=0",
    success: function(data){
  	  var $result = $(data);
  	  $result.find("#music_score_list > li > a").each(function(){
  		songLink.push($(this).attr('href'));
      });
      $("#scoreToolScraping").append('SONG LIST ' + (i + 1) + text.load_songlist[lang]);
      i++;
      if($result.find(".common_next_btn").length) setTimeout(getSongLink, LOAD_DELAY); // if next button exist, load next page
      else { // if next button does not exist, start loading song details
        i = 0;
        $("#scoreToolScraping").append(text.songlist_success[lang]);
        Promise.all(songLink.map(getSongDetail))
          .then(data => data.reduce((a, b) => a.concat(b);))
          .then(data => {
            $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: "https://localhost:13579/score/save",
            data: JSON.stringify(data),
            success: function (result) {
              console.log("done!");
            }});
      })
      }
    },
    error: function(request, status, error){
      if(ajaxError(request, status, error, getPlayerData) === "timeout" && retryCount < RETRY_MAX) {
        $("#scoreToolScraping").append('Response Timeout... ' + (++retryCount) + 'th retry...<br>');
        setTimeout(getSongLink, RETRY_DELAY);
      }
      else
  　}
  });
}

function getSongDetail(url) {
  return new Promise(function (resolve, reject) {
    $.get('//p.eagate.573.jp/' + url, function (response) {
      var songArr = [];
      var result = $(response);
      for(var i = 0; i<3; i++) {
          var songDetail = {"title": null, "artist": null, "difficulty": -1, "level": -1, "score": -1, "connect": -1, "caCount": -1, "playCount": -1};

          songDetail.title = result.find("#playdata_music_name").text();
          songDetail.title = jsonErrorAvoid(songDetail.title);
          songDetail.artist = result.find("#playdata_music_artist").text();
          songDetail.artist = jsonErrorAvoid(songDetail.artist);
          songDetail.difficulty = i + 1;
          songDetail.level = parseInt(result.find(".detail_header_inner > .difficult")[i].innerText.split(' ')[1]);

          var difficultyDetail = result.find(".detail_data_inner .value");
          songDetail.score = parseInt(difficultyDetail[i * 4].innerText) || 0;
          songDetail.connect = parseInt(difficultyDetail[i * 4 + 1].innerText) || 0;
          songDetail.caCount = parseInt(difficultyDetail[i * 4 + 2].innerText) || 0;
          songDetail.playCount = parseInt(difficultyDetail[i * 4 + 3].innerText) || 0;

          songArr.push(songDetail);
      }

      $("#scoreToolScraping").append(songArr[0].title + text.songdata_load[lang]);
      $("#scoreToolScraping")[0].scrollTop = $("#scoreToolScraping")[0].scrollHeight;
      resolve(songArr);
    });
  });
}

function jsonErrorAvoid(str){
  str = str.replace(/\[/g, "&#91;");
  str = str.replace(/\]/g, "&#93;");
  str = str.replace(/\{/g, "&#123;");
  str = str.replace(/\}/g, "&#125;");
  str = str.replace(/\"/g, "&quot;");
  str = str.replace(/\'/g, "&#39;");
  return str;
}

function ajaxError(request, status, error, funcName){
  if(error === "timeout") return "timeout"; // timeout err
  else $("#scoreToolScraping").append('Error code : ' + request.status + text.ajax_error);
}
