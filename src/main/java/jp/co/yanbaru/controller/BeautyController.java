package jp.co.yanbaru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeautyController {

    @GetMapping("/")
    public String index() {
        return "redirect:/diagnosis";
    }

    @GetMapping("/diagnosis")
    public String diagnosis() {
        return "diagnosis";
    }

    @PostMapping("/diagnosis/result")
    public String result(
            @RequestParam String skinType,
            @RequestParam String concern,
            @RequestParam String makeupStyle,
            Model model) {

        String resultTitle;
        String resultText;
        String recommendedItem;
        String careAdvice;
        int beautyScore;

        String brand1;
        String brand2;
        String brand3;
        String brandReason;
        String productImage;

        if (skinType.equals("dry") && makeupStyle.equals("natural")) {
            resultTitle = "うるおいナチュラルタイプ";
            resultText = "乾燥しやすい肌に、自然なメイクが似合うタイプです。ツヤ感を意識すると魅力が引き立ちます。";
            recommendedItem = "保湿化粧水、クリーム、ツヤ系ファンデーション";
            careAdvice = "朝と夜の保湿をしっかり行いましょう。";
            beautyScore = 85;

            brand1 = "キュレル";
            brand2 = "肌ラボ";
            brand3 = "無印良品";
            brandReason = "高保湿アイテムが豊富で、乾燥しやすい肌をサポートしてくれるブランドです。";
            productImage = "/images/dry.png";

        } else if (skinType.equals("dry") && makeupStyle.equals("cute")) {
            resultTitle = "ふんわり保湿キュートタイプ";
            resultText = "保湿しながら、かわいらしい印象を作るのが得意なタイプです。";
            recommendedItem = "保湿下地、ピンク系チーク、うるおいリップ";
            careAdvice = "頬や口元の乾燥対策を丁寧にしましょう。";
            beautyScore = 88;

            brand1 = "キャンメイク";
            brand2 = "セザンヌ";
            brand3 = "エクセル";
            brandReason = "かわいらしいメイクに合わせやすく、コスパの良いアイテムが豊富なブランドです。";
            productImage = "/images/dry.png";

        } else if (skinType.equals("oily") && makeupStyle.equals("cool")) {
            resultTitle = "さらさらクールビューティータイプ";
            resultText = "皮脂をコントロールしながら、落ち着いた印象を作れるタイプです。";
            recommendedItem = "皮脂崩れ防止下地、フェイスパウダー、ブラウン系アイシャドウ";
            careAdvice = "テカリやすい部分にはパウダーを軽くのせましょう。";
            beautyScore = 90;

            brand1 = "ラロッシュポゼ";
            brand2 = "オバジ";
            brand3 = "ケイト";
            brandReason = "皮脂ケアと崩れにくさを重視したアイテムが多く、クールな印象に合わせやすいブランドです。";
            productImage = "/images/oily.png";

        } else if (skinType.equals("oily") && makeupStyle.equals("natural")) {
            resultTitle = "さっぱりナチュラルタイプ";
            resultText = "清潔感のある自然なメイクが似合うタイプです。";
            recommendedItem = "さっぱり化粧水、軽めの乳液、皮脂崩れ防止下地";
            careAdvice = "洗顔で皮脂を落としすぎず、軽い保湿をしましょう。";
            beautyScore = 82;

            brand1 = "無印良品";
            brand2 = "キュレル";
            brand3 = "肌ラボ";
            brandReason = "シンプルなケアで肌のバランスを整えやすく、ナチュラルな印象に合うブランドです。";
            productImage = "/images/oily.png";

        } else if (skinType.equals("sensitive")) {
            resultTitle = "やさしい敏感肌ケアタイプ";
            resultText = "刺激を受けやすい肌なので、低刺激アイテムを選ぶことが大切です。";
            recommendedItem = "低刺激化粧水、ミネラルファンデーション、無香料クリーム";
            careAdvice = "新しい化粧品を使うときは、少量から試しましょう。";
            beautyScore = 80;

            brand1 = "キュレル";
            brand2 = "ミノン";
            brand3 = "ラロッシュポゼ";
            brandReason = "低刺激処方の商品が多く、敏感肌の方でも使いやすいブランドです。";
            productImage = "/images/sensitive.png";

        } else {
            resultTitle = "バランス美容タイプ";
            resultText = "肌のバランスが比較的整っていて、色々なメイクに挑戦しやすいタイプです。";
            recommendedItem = "美容液、ナチュラル系ベースメイク、好みに合ったリップ";
            careAdvice = "保湿・洗顔・紫外線対策を続けましょう。";
            beautyScore = 84;

            brand1 = "無印良品";
            brand2 = "エリクシール";
            brand3 = "オルビス";
            brandReason = "幅広い肌悩みに対応しやすく、毎日のケアに取り入れやすいブランドです。";
            productImage = "/images/normal.png";
        }

        if (concern.equals("acne")) {
            careAdvice += " ニキビが気になる場合は、油分の多いアイテムを控えめにしましょう。";
            brandReason += " また、ニキビが気になる場合は、重すぎない使用感のアイテムを選ぶのがおすすめです。";
            beautyScore -= 3;
        } else if (concern.equals("pores")) {
            careAdvice += " 毛穴が気になる場合は、洗顔後の保湿を忘れないようにしましょう。";
            brandReason += " 毛穴が気になる場合は、洗顔・保湿・ベースメイクをバランスよく選ぶと良いです。";
            beautyScore -= 2;
        } else if (concern.equals("dullness")) {
            careAdvice += " くすみが気になる場合は、血色感のある下地やチークを取り入れると良いです。";
            brandReason += " くすみが気になる場合は、明るい印象を作れるベースメイク系ブランドも相性が良いです。";
            beautyScore -= 1;
        } else {
            careAdvice += " 大きな悩みがない場合も、毎日のケアを続けることが大切です。";
        }

        model.addAttribute("resultTitle", resultTitle);
        model.addAttribute("resultText", resultText);
        model.addAttribute("recommendedItem", recommendedItem);
        model.addAttribute("careAdvice", careAdvice);
        model.addAttribute("beautyScore", beautyScore);

        model.addAttribute("brand1", brand1);
        model.addAttribute("brand2", brand2);
        model.addAttribute("brand3", brand3);
        model.addAttribute("brandReason", brandReason);
        model.addAttribute("productImage", productImage);

        return "result";
    }
}