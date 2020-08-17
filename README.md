# ChestWorld
チェストな世界

## 対応バージョン
Minecraft: 1.16.x<br>
Minecraft Forge: 32.0.0以上<br>
http://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.16.1.html

## 概説
1m四方のチェストブロックと、チェストブロックのみで構成されたバイオーム、<br>
そのバイオームのみを生成するワールドタイプを追加します。<br>
チェストブロックは右クリックすることで、ランダムなルートテーブルが適用されたチェストに変化します。<br>
確率で、爆発したり、モブが湧いたり、スポナーに変化したりします。<br>
ルートテーブルは、バニラ38種+オリジナル25種の計63あり、レアリティが6段階で分かれています。<br>
レアリティによって出現確率が異なります。
マルチサーバーの場合は、強制的にワールドタイプが固定されます。

## configファイル
Modを導入した状態で一回でも起動すると、configフォルダ内にchestworld-client.tomlが生成されます。<br>
値の変更は次回の起動時に適用されます。
- Base Weight
  - 各レア度の排出割合です。<br>
    レアリティの順は、低い方からMiss/Common/Uncommon/Rare/VeryRare/UltraRare/Legendaryです。<br>
    Missに限り、ルートテーブルではなく、モブスポーン/爆発/スポナー設置のいずれかが起こります。<br>
    確率の算出式は、(指定したweight値)÷(全weight値の合計)です。<br>
    よって、全体の合計が100である必要はありません。
- Miss Weight
  - Missが抽選されたときの、各現象の排出割合です。<br>
    spawn_mobs_weightがモブがスポーンする割合、<br>
    explosion_weightが爆発が起こる割合、<br>
    spawner_weightがスポナーが設置される割合です。<br>
    確率の算出式は、上に同じです。

## 注意点
- 特になし。
