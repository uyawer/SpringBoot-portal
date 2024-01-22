# SpringBoot-portal

学習用にSpringBootとThymeleafで作るPortal疑似サイト

名前が思いつかん😠💢

## できること&やりたいこと

### 画面

- [ ] ログイン
  - [x] ID/Passwordによるログイン
  - [ ] OAuthによるログイン
- [ ] 全従業員メニュー
  - [ ] ダッシュボード
  - [ ] 従業員情報
    - [ ] 登録情報確認
    - [ ] 登録情報編集
    - [ ] パスワード変更
- [ ] 管理者メニュー
  - [ ] グループ管理
    - [ ] 一覧/検索
    - [ ] 追加
    - [ ] 更新
    - [ ] 削除
  - [ ] 従業員管理
    - [ ] 一覧/検索
    - [ ] 追加
    - [ ] 更新
    - [x] 削除

### その他システム的な部分

- [x] パンくず表示
- [x] 権限毎の表示制御
- [ ] 排他制御
- [ ] セッション管理
  - [ ] NoSQLによるセッション管理
- [ ] メール通知
- [ ] ポップアップ表示

## プロジェクト構成

```txet
[ProjectRoot]
 └─src
    ├─main
    │  ├─java/com/uyawer/portal
    │  │  ├─constants      <-- 定数クラス
    │  │  │  └─type        <-- Enum
    │  │  ├─controller     <-- 各画面/機能とサービスを繋げるクラス(URLリクエストの受け口)
    │  │  ├─exception      <-- 例外系を扱うクラス
    │  │  ├─helper         <-- コントローラーのヘルパー(modelやcsvへの変換を扱うクラス)
    │  │  │  └─utils       <-- 日付のフォーマットや数値の整形などの共通処理を扱うクラス
    │  │  ├─model
    │  │  │  ├─dto         <-- 画面に表示する値を扱うモデル
    │  │  │  ├─entity      <-- DBと直接値をやり取りするモデル
    │  │  │  ├─form        <-- 画面からのレスポンスを受け取るモデル
    │  │  │  └─response    <-- APIから返却されるレスポンスを扱うモデル
    │  │  ├─repository     <-- 外部(DBやAPI)とやり取りするクラス
    │  │  ├─security       <-- SpringSecurityの設定
    │  │  ├─service        <-- 外部(DBやAPI)とやり取りするために必要な加工をするクラスのI/F
    │  │  │  └─impl        <-- 外部(DBやAPI)とやり取りするために必要な加工をするクラスの実装
    │  │  └─validation     <-- バリデーションチェックを扱うクラス
    │  │     └─anotation   <-- バリデーションチェックを扱うアノテーション
    │  └─resources
    │     ├─db/migration   <-- flywayで実行するSQL
    │     ├─static         <-- 静的ファイルの置き場所
    │     │  ├─css         <-- 独自のCSS
    │     │  └─js          <-- 独自のJavaScript
    │     └─templates      <-- ブラウザに表示するHTML
    └─test
       ├─groovy            <-- Spockでのユニットテスト
       ├─java              <-- JUnitでのユニットテスト
       └─resources
```

参考: <https://zenn.dev/naoki_oshiumi/articles/0467a0ecf4d56a>

## REST APIのURI定義の方針

APIに限らず、画面のURLもこの方針に沿ってしまっていいと思います。

```text
GET    : /datas              <-- データ一覧取得
GET    : /datas/{id}         <-- 1件のデータ取得
GET    : /datas/{id}/column  <-- 特定データの特定項目を取得
POST   : /datas              <-- データ発生(ここでIDができる）
PUT    : /datas/{id}         <-- 特定データの一括更新
PUT    : /datas/{id}/column  <-- 特定データを1個だけ更新
PATCH  : /datas/{id}         <-- 特定データの複数項目を更新
DELETE : /datas/{id}         <-- 特定データの削除 
```

## 開発環境構築手順

### docker-compose

リソース以外の環境はDockerを用いて準備します。
Dockerのインストール手順については省略します。

PowerShellなどからDockerに新しいvolumeを作成します。

```ps1
docker volume create --name portal-db-volume -d local
```

gradleから`composeUp`を実行します。

```ps1
./gradlew composeUp
```

#### Dockerでインストールされる環境

- DB(PostgreSQL)
  - DB名: `portal`
  - ユーザー名: `portaluser`
  - パスワード: `portaluser0428`

### EditorConfig

インデントやフォーマットを揃えるために[EditorConfig](https://editorconfig.org/)を導入しています。

- 初期から有効になっているIDE
  - IntelliJ IDEA など
    - `Ctrl + Alt + L`でフォーマット
- プラグインをインストールすると有効になるIDE
  - Eclipse([Plugin](https://marketplace.eclipse.org/node/2506426))
    - `Ctrl + Shift + F`でフォーマット
  - Visual Studio Code([Plugin](https://marketplace.visualstudio.com/items?itemName=EditorConfig.EditorConfig)) など

### Dockerで作成したPostgreSQLへのログイン

#### Intellij IDEA, DataGrip

- URL: `jdbc:postgresql://localhost:15432/portal`
- ユーザー: `portaluser`
- パスワード: `portaluser0428`

### A5:SQL Mk-2

- 接続タイプ: `PostgreSQL`
- サーバー名: `localhost`
- ポート番号: `15432`
- データーベース名: `portal`
- ユーザーID: `portaluser`
- パスワード: `portaluser0428`

### DBマイグレーション

gradleから`flywayMigrate`を実行します。

```ps1
./gradlew flywayMigrate
```

間違えたSQLを実行してしまった場合は`flywayClean`を実行します。

```ps1
./gradlew flywayClean
```

### (optional) Bootstrap5を配置

BootstrapのリソースはCDN経由で取得しているため、リポジトリ内では取り扱っていません。  
が、配置しておくとBootstrapのCSSやJavaScriptがどう動いているかを確認できたり、IDEによっては補完をしてくれます。

Bootstrap v5.0.2
https://getbootstrap.com/docs/5.0/getting-started/download/

ダウンロードしたBootstrap5のCSSとJavaScriptは`src/main/resources/static`に展開してください。  
（ファイル名に`~min`/`~rtl`/`~esm`が付いているファイルは使用していない/デバッグ上では見辛いので省いても問題ありません。）

## 起動

### local用の環境変数の設定

`resources/application-local.yml-template`をコピーして、同じフォルダー内に`application-local.yml`を作成します。

### 実行構成

メインクラスには以下を設定してください。

```java
com.uyawer.portal.PortalApplication
```

localでの開発時はVMオプションに以下を指定してください。

```txet
-Dspring.profiles.active=local
```

### URL

[http://localhost:8080/](http://localhost:8080/)
