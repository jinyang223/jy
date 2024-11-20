window.onload= function(){
	
		/*  1、画像を自動的に切り替える
		2、マウスを画像にホバーさせると、一時停止し、マウスを外すと、画像が再開する
		3、左右の2つのボタンをクリックすると、前の画像または次の画像に切り替える
		4、下の4つの小さな円が画像に合わせて色を変更する
		5、小さな円をクリックすると、対応する画像に切り替える
		*/

		// 円点を配置するボックスノード、つまりpノードを取得する
        let pEle = document.getElementsByTagName("p")[0];
        // イベントデリゲートの親要素sectionを取得する
        let secEle = document.getElementsByTagName("section")[0];
 
        let imgArr = [
            "https://baoxian.pingan.com/uploadfile/clause/image/website/1670833686560.jpg",
            "https://baoxian.pingan.com/uploadfile/clause/image/website/1656322263966.jpg",
        ]
        // 時間関数の開始インデックスを取得する
        let i = 0;
        // 画像がいくつあるか、その分だけパラメーターを渡し、そしてこの返される配列を受け取る
        let cirArr = creatCircle(imgArr.length);
        // cirArr配列を反復処理し、円点をその親要素であるpノードに追加する
        cirArr.forEach(node => pEle.appendChild(node));
        // すべての円点ノードを取得する 
        let iEle = document.getElementsByTagName("i");
        // 各円点にカスタム属性を追加し、インデックスを割り当てる 
        for (let k = 0; k < iEle.length; k++) {
            iEle[k].dataset.index = k;
        }
 
        let timer;
        // 轮播：タイマー関数で1秒ごとに画像を自動的に切り替える 
        function playTime() {
            timer = setInterval(() => {
                // 画像をループで表示する
                i++;
                // もし最後の画像にジャンプしている場合は、再び最初の画像に戻る
                if (i > imgArr.length - 1) {
                    i = 0;
                }
                // 円点にスタイルを追加し、この関数を開始する
                addStyleI(i);
                 // 画像タグのアドレス（src属性）
                img.src = imgArr[i];
            }, 5000);
        }
        playTime();
 
        // マウスオーバーで画像が一時停止
        secEle.addEventListener("mouseenter", function () {
            clearInterval(timer);
            timer = null;
        });
        // マウスアウトで画像がスクロールを再開 
        secEle.addEventListener("mouseleave", playTime);
 
        // 親ノードにイベントデリゲートをバインドし、左右のボタンをクリックして画像を切り替える
        secEle.addEventListener("click", function (e) {
            let event = e || window.event;
            // 左右のボタンをクリックして画像を切り替える
            if (event.target.className == "left iconfont icon-anniu_jiantouxiangzuo") {
                i--;
            }
            if (event.target.className == "right iconfont icon-anniu-jiantouxiangyou") {
                i++;
            }
            if (i < 0) {
                i = imgArr.length - 1;
            }
            if (i == imgArr.length) {
                i = 0;
            }
            img.src = imgArr[i];
            addStyleI(i);
            // 小さい円点をクリックして対応する画像に切り替える
            if (event.target.nodeName == "I") {
                console.log("11111");
                // クリックされた円点のカスタムインデックス値を取得する
                cirI = event.target.dataset.index;
                // 画像を置き換える
                img.src = imgArr[cirI];
                // 円点のスタイルを変更する
                addStyleI(cirI);
                // 小さい円点をクリックするたびに、iの値が円点のインデックス値に設定される
                i = cirI;
            }
        });
 
        // 画像のスクロールを一時停止する
        function picScroll() {
            clearInterval(timer);
        }
 
        // 円点を生成する
        function creatCircle(num) {
            // 空の配列を作成してこの円点を受信する
            let iArr = [];
            for (let j = 0; j < num; j++) {
                // 新しい円点ノードを追加する
                let circleNode = document.createElement("i");
                // 新しい円点ノードを円点配列に入れる
                iArr.push(circleNode);
            }
            // 完了後に、その配列を返す
            return iArr;
        }
 
        // 円点にスタイルを追加する
        function addStyleI(index) {
           	// 円点のデフォルトカラーはグレーです
            [...iEle].forEach(node => node.style.backgroundColor = "gray");
            // その画像にジャンプしたとき、円点は白くなる
            iEle[index].style.backgroundColor = "white";
        }
}