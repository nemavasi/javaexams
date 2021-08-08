package javaexams;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;                  //look at jol dependency in POM!

public class ObjectsSizeInBytes {

    public static void main(String[] args) {
        System.out.println(VM.current().details());  //...Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
//
//        Object references 4 bytes
//        boolean and byte values 1 byte
//        short and char values 2 bytes
//        int and float values 4 bytes
//        long and double values 8 bytes

        int[][]  m= new int[2][500];
        System.out.println(ClassLayout.parseInstance(m).toPrintable());

//[[I object internals:
//        OFF  SZ   TYPE DESCRIPTION               VALUE
//        0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
//        8   4        (object header: class)    0x08000710
//        12   4        (array length)            2
//        12   4        (alignment/padding gap)
//        16   8     [I [[I.<elements>            N/A
//        Instance size: 24 bytes
//        Space losses: 4 bytes internal + 0 bytes external = 4 bytes total

        System.out.println(GraphLayout.parseInstance(m).toFootprint());

//        [I@612679d6d, [I@11758f2ad footprint:
//        COUNT       AVG       SUM   DESCRIPTION
//        2          2016      4032   [I
//        2                    4032   (total)

        m= new int[500][2];
        System.out.println(GraphLayout.parseInstance(m).toFootprint());

//        [I@6950e31d, [I@b7dd107d, [I@42eca56ed, [I@52f759d7d, [I@7cbd213ed, [I@192d3247d, [I@3ecd23d9d, [I@569cfc36d, [I@43bd930ad, [I@33723e30d, [I@64f6106cd, [I@553a3d88d, [I@7a30d1e6d, [I@5891e32ed, [I@cb0ed20d, [I@8e24743d, [I@74a10858d, [I@23fe1d71d, [I@28ac3dc3d, [I@32eebfcad, [I@4e718207d, [I@1d371b2dd, [I@543c6f6dd, [I@13eb8acfd, [I@51c8530fd, [I@7403c468d, [I@43738a82d, [I@c81cdd1d, [I@1fc2b765d, [I@75881071d, [I@2a70a3d8d, [I@289d1c02d, [I@22eeefebd, [I@17d0685fd, [I@3891771ed, [I@78ac1102d, [I@2de8284bd, [I@396e2f39d, [I@a74868dd, [I@12c8a2c0d, [I@7e0e6aa2d, [I@365185bdd, [I@18bf3d14d, [I@4fb64261d, [I@42607a4fd, [I@782663d3d, [I@1990a65ed, [I@64485a47d, [I@25bbf683d, [I@6ec8211cd, [I@7276c8cdd, [I@544a2ea6d, [I@2e3fc542d, [I@150c158d, [I@4524411fd, [I@401e7803d, [I@10dba097d, [I@1786f9d5d, [I@704d6e83d, [I@43a0cee9d, [I@eb21112d, [I@2eda0940d, [I@3578436ed, [I@706a04aed, [I@6eceb130d, [I@10a035a0d, [I@67b467e9d, [I@47db50c5d, [I@5c072e3fd, [I@4d1b0d2ad, [I@954b04fd, [I@149494d8d, [I@710726a3d, [I@646007f4d, [I@481a15ffd, [I@78186a70d, [I@306279eed, [I@545997b1d, [I@4cf4d528d, [I@77846d2cd, [I@548ad73bd, [I@4c762604d, [I@2641e737d, [I@727803ded, [I@704921a5d, [I@df27faed, [I@24a35978d, [I@16f7c8c1d, [I@2f0a87b3d, [I@319b92f3d, [I@fcd6521d, [I@27d415d9d, [I@5c18298fd, [I@31f924f5d, [I@5579bb86d, [I@5204062dd, [I@4fcd19b3d, [I@376b4233d, [I@2fd66ad3d, [I@5d11346ad, [I@7a36aefad, [I@17211155d, [I@b3d7190d, [I@5fdba6f9d, [I@10d59286d, [I@fe18270d, [I@6fb0d3edd, [I@6dde5c8cd, [I@5123a213d, [I@52525845d, [I@3b94d659d, [I@24b1d79bd, [I@68ceda24d, [I@281e3708d, [I@35a50a4cd, [I@1f021e6cd, [I@103f852d, [I@587c290dd, [I@4516af24d, [I@4ae82894d, [I@543788f3d, [I@6d3af739d, [I@1da51a35d, [I@16022d9dd, [I@7e9a5fbed, [I@44a3ec6bd, [I@71623278d, [I@768b970cd, [I@5a4041ccd, [I@15b3e5bd, [I@61ca2dfad, [I@4b53f538d, [I@134593bfd, [I@4bb4de6ad, [I@7ba18f1bd, [I@2f8f5f62d, [I@1068e947d, [I@7dc222aed, [I@aecb35ad, [I@5fcd892ad, [I@8b87145d, [I@6483f5aed, [I@b9afc07d, [I@382db087d, [I@73d4cc9ed, [I@80169cfd, [I@5427c60cd, [I@15bfd87d, [I@543e710ed, [I@57f23557d, [I@3d0f8e03d, [I@6366ebe0d, [I@44f75083d, [I@2698dc7d, [I@43d7741fd, [I@17baae6ed, [I@69379752d, [I@27fe3806d, [I@5f71c76ad, [I@1d7acb34d, [I@48a242ced, [I@1e4a7dd4d, [I@4f51b3e0d, [I@4b9e255d, [I@5e57643ed, [I@133e16fdd, [I@51b279c9d, [I@1ad282e0d, [I@7f416310d, [I@1cab0bfbd, [I@5e955596d, [I@50de0926d, [I@2473b9ced, [I@60438a68d, [I@140e5a13d, [I@3439f68dd, [I@dbd940dd, [I@71d15f18d, [I@17695df3d, [I@6c9f5c0dd, [I@de3a06fd, [I@76b10754d, [I@2bea5ab4d, [I@3d8314f0d, [I@2df32bf7d, [I@530612bad, [I@2a40cd94d, [I@f4168b8d, [I@3bd94634d, [I@58a90037d, [I@74294adbd, [I@70a9f84ed, [I@130f889d, [I@1188e820d, [I@2f490758d, [I@101df177d, [I@166fa74dd, [I@40f08448d, [I@276438c9d, [I@588df31bd, [I@33b37288d, [I@77a57272d, [I@7181ae3fd, [I@46238e3fd, [I@6e2c9341d, [I@32464a14d, [I@4e4aea35d, [I@1442d7b5d, [I@1efee8e7d, [I@1ee807c6d, [I@76a4d6cd, [I@517cd4bd, [I@6cc7b4ded, [I@32cf48b7d, [I@679b62afd, [I@5cdd8682d, [I@d6da883d, [I@45afc369d, [I@799d4f69d, [I@49c43f4ed, [I@290dbf45d, [I@12028586d, [I@17776a8d, [I@69a10787d, [I@2d127a61d, [I@2bbaf4f0d, [I@11c20519d, [I@70beb599d, [I@4e41089dd, [I@32a068d1d, [I@33cb5951d, [I@365c30ccd, [I@701fc37ad, [I@4148db48d, [I@282003e1d, [I@7fad8c79d, [I@71a794e5d, [I@76329302d, [I@5e25a92ed, [I@4df828d7d, [I@b59d31d, [I@62fdb4a6d, [I@11e21d0ed, [I@1dd02175d, [I@31206bebd, [I@3e77a1edd, [I@3ffcd140d, [I@23bb8443d, [I@1176dcecd, [I@120d6fe6d, [I@4ba2ca36d, [I@3444d69dd, [I@1372ed45d, [I@6a79c292d, [I@37574691d, [I@25359ed8d, [I@21a947fed, [I@5606c0bd, [I@80ec1f8d, [I@1445d7fd, [I@6a396c1ed, [I@6c3f5566d, [I@12405818d, [I@314c508ad, [I@10b48321d, [I@6b67034d, [I@16267862d, [I@453da22cd, [I@71248c21d, [I@442675e1d, [I@6166e06fd, [I@49e202add, [I@1c72da34d, [I@6b0c2d26d, [I@3d3fcdb0d, [I@641147d0d, [I@6e38921cd, [I@64d7f7e0d, [I@27c6e487d, [I@49070868d, [I@6385cb26d, [I@38364841d, [I@28c4711cd, [I@59717824d, [I@146044d7d, [I@1e9e725ad, [I@15d9bc04d, [I@473b46c3d, [I@516be40fd, [I@3c0a50dad, [I@646be2c3d, [I@797badd3d, [I@77be656fd, [I@19dc67c2d, [I@221af3c0d, [I@62bd765d, [I@23a5fd2d, [I@78a2da20d, [I@dd3b207d, [I@551bdc27d, [I@58fdd99d, [I@6b1274d2d, [I@7bc1a03dd, [I@70b0b186d, [I@ba8d91cd, [I@7364985fd, [I@5d20e46d, [I@709ba3fbd, [I@3d36e4cdd, [I@6a472554d, [I@7ff2a664d, [I@525b461ad, [I@58c1c010d, [I@b7f23d9d, [I@61d47554d, [I@69b794e2d, [I@3f200884d, [I@4d339552d, [I@f0f2775d, [I@5a4aa2f2d, [I@6591f517d, [I@345965f2d, [I@429bd883d, [I@4d49af10d, [I@279ad2e3d, [I@58134517d, [I@4450d156d, [I@4461c7e3d, [I@351d0846d, [I@77e4c80fd, [I@35fc6dc4d, [I@7fe8ea47d, [I@226a82c4d, [I@731f8236d, [I@255b53dcd, [I@1dd92fe2d, [I@6b53e23fd, [I@64d2d351d, [I@1b68b9a4d, [I@4f9a3314d, [I@3b2c72c2d, [I@491666add, [I@176d53b2d, [I@971d0d8d, [I@51931956d, [I@2b4a2ec7d, [I@564718dfd, [I@51b7e5dfd, [I@18a70f16d, [I@62e136d3d, [I@c8e4bb0d, [I@6279cee3d, [I@4206a205d, [I@29ba4338d, [I@57175e74d, [I@7bb58ca3d, [I@c540f5ad, [I@770c2e6bd, [I@1a052a00d, [I@4d826d77d, [I@61009542d, [I@77e9807fd, [I@448ff1a8d, [I@1a38c59bd, [I@7f77e91bd, [I@44a664f2d, [I@7f9fcf7fd, [I@2357d90ad, [I@6328d34ad, [I@145eaa29d, [I@15bb6bead, [I@8b96fded, [I@2d2e5f00d, [I@4c40b76ed, [I@2ea6137d, [I@41ee392bd, [I@1e67a849d, [I@57d5872cd, [I@667a738d, [I@36f0f1bed, [I@157632c9d, [I@6ee12bacd, [I@55040f2fd, [I@64c87930d, [I@400cff1ad, [I@275710fcd, [I@525f1e4ed, [I@75f9ecccd, [I@52aa2946d, [I@4de5031fd, [I@67e2d983d, [I@5d47c63fd, [I@5ea434c8d, [I@3bbc39f8d, [I@4ae3c1cdd, [I@29f69090d, [I@568bf312d, [I@ca263c2d, [I@589b3632d, [I@45f45fa1d, [I@4c6e276ed, [I@534df152d, [I@52e677afd, [I@35083305d, [I@8e0379dd, [I@341b80b2d, [I@55a1c291d, [I@2145433bd, [I@2890c451d, [I@40e6dfe1d, [I@1b083826d, [I@105fece7d, [I@3ec300f1d, [I@482cd91fd, [I@123f1134d, [I@7d68ef40d, [I@5b0abc94d, [I@75c072cbd, [I@1f1c7bf6d, [I@25b485bad, [I@2b546384d, [I@5d740a0fd, [I@214b199cd, [I@20d3d15ad, [I@2893de87d, [I@55ca8de8d, [I@2c34f934d, [I@12d3a4e9d, [I@240237d2d, [I@25a65b77d, [I@2ed0fbaed, [I@212bf671d, [I@14a2f921d, [I@3c87521d, [I@2aece37dd, [I@548a102fd, [I@5762806ed, [I@17c386ded, [I@5af97850d, [I@5ef60048d, [I@1d548a08d, [I@16aa0a0ad, [I@780cb77d, [I@691a7f8fd, [I@50a7bc6ed, [I@161b062ad, [I@17c1bcedd, [I@2d9d4f9dd, [I@4034c28cd, [I@e50a6f6d, [I@14ec4505d, [I@53ca01a2d, [I@358c99f5d, [I@3ee0fea4d, [I@48524010d, [I@4b168fa9d, [I@1a84f40fd, [I@23282c25d, [I@7920ba90d, [I@6b419dad, [I@3b2da18fd, [I@5906ebcbd, [I@258e2e41d, [I@3d299e3d, [I@55a561cfd, [I@3b938003d, [I@6f3b5d16d, [I@78b1cc93d, [I@6646153d, [I@21507a04d, [I@143640d5d, [I@6295d394d, [I@475e586cd, [I@657c8ad9d, [I@436a4e4bd, [I@f2f2cc1d, [I@3a079870d, [I@3b2cf7abd, [I@2aa5fe93d, [I@5c1a8622d, [I@5ad851c9d, [I@6156496d, [I@3c153a1d, [I@b62fe6dd, [I@13acb0d1d, [I@3e3047e6d, [I@37e547dad, [I@2b6856ddd, [I@5db45159d, [I@6107227ed, [I@7c417213d, [I@15761df8d, [I@6ab7a896d, [I@327b636cd, [I@45dd4edad, [I@60611244d, [I@3745e5c6d, [I@5e4c8041d, [I@71c8beccd, [I@19d37183d footprint:
//        COUNT       AVG       SUM   DESCRIPTION
//        500        24     12000   [I
//        500               12000   (total)

    }
}
