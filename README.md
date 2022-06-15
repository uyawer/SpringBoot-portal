# SpringBoot-v2.7.0-portal

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

## 開発環境構築手順

### docker-compose.yml

リソース以外の環境はDockerを用いて準備します。

gradleから`composeUp`を実行します。

```ps1
./gradlew composeUp
```

#### Dockerでインストールされる環境

- DB(PostgreSQL)
    - DB名: `portal`
    - ユーザー名: `portaluser`
    - パスワード: `portaluser0428`

### DBマイグレーション

gradleから`flywayMigrate`を実行します。

```ps1
./gradlew flywayMigrate
```

## 起動

localでの開発時はVMオプションに以下を指定してください。

```
-Dspring.profiles.active=local
```

[http://localhost:8080/](http://localhost:8080/)
