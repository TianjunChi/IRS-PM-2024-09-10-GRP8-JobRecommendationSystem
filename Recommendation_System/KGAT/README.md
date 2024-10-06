# Knowledge Graph Attention Network
This is PyTorch implementation for the paper:
>Xiang Wang, Xiangnan He, Yixin Cao, Meng Liu and Tat-Seng Chua (2019). KGAT: Knowledge Graph Attention Network for Recommendation. [Paper in ACM DL](https://dl.acm.org/authorize.cfm?key=N688414) or [Paper in arXiv](https://arxiv.org/abs/1905.07854). In KDD'19, Anchorage, Alaska, USA, August 4-8, 2019.

You can find Tensorflow implementation by the paper authors [here](https://github.com/xiangwang1223/knowledge_graph_attention_network).

## Introduction
Knowledge Graph Attention Network (KGAT) is a new recommendation framework tailored to knowledge-aware personalized recommendation. Built upon the graph neural network framework, KGAT explicitly models the high-order relations in collaborative knowledge graph to provide better recommendation with item side information.

If you want to use codes and datasets in your research, please contact the paper authors and cite the following paper as the reference:
```
@inproceedings{KGAT19,
  author    = {Xiang Wang and
               Xiangnan He and
               Yixin Cao and
               Meng Liu and
               Tat{-}Seng Chua},
  title     = {{KGAT:} Knowledge Graph Attention Network for Recommendation},
  booktitle = {{KDD}},
  pages     = {950--958},
  year      = {2019}
}
```

## Environment Requirement
The code has been tested running under Python 3.7.10. The required packages are as follows:
* torch == 1.6.0
* numpy == 1.21.4
* pandas == 1.3.5
* scipy == 1.5.2
* tqdm == 4.62.3
* scikit-learn == 1.0.1

## Run the Codes
* FM
```
python main_nfm.py --model_type fm --data_name amazon-book
```
* NFM
```
python main_nfm.py --model_type nfm --data_name amazon-book
```
* BPRMF
```
python main_bprmf.py --data_name amazon-book
```
* ECFKG
```
python main_ecfkg.py --data_name amazon-book
```
* CKE
```
python main_cke.py --data_name amazon-book
```
* KGAT
```
python main_kgat.py --data_name amazon-book
```

## Results
With my code, following are the results of each model when training with dataset `amazon-book`.

| Model                                             | Best Epoch | Precision@20 | Recall@20 | NDCG@20 |
| :---:                                             | :---:      | :---:        | :---:     | :---:   |
| FM                                                | 370        | 0.0154       | 0.1478    | 0.0784  |
| NFM                                               | 140        | 0.0137       | 0.1309    | 0.0696  |
| BPRMF                                             | 330        | 0.0146       | 0.1395    | 0.0736  |
| ECFKG                                             |  10        | 0.0134       | 0.1264    | 0.0663  |
| CKE                                               | 320        | 0.0145       | 0.1394    | 0.0733  |
| KGAT <br> (agg: bi-interaction; lap: random-walk) | 280        | 0.0150       | 0.1440    | 0.0766  |
| KGAT <br> (agg: bi-interaction; lap: symmetric)   | 200        | 0.0149       | 0.1428    | 0.0755  |
| KGAT <br> (agg: graphsage;      lap: random-walk) | 450        | 0.0147       | 0.1430    | 0.0747  |
| KGAT <br> (agg: graphsage;      lap: symmetric)   | 160        | 0.0146       | 0.1410    | 0.0735  |
| KGAT <br> (agg: gcn;            lap: random-walk) | 280        | 0.0149       | 0.1440    | 0.0760  |
| KGAT <br> (agg: gcn;            lap: symmetric)   | 670        | 0.0150       | 0.1448    | 0.0768  |

## Related Papers
* FM
    * Proposed in [Fast context-aware recommendations with factorization machines](https://dl.acm.org/citation.cfm?id=2010002), SIGIR 2011.

* NFM
    * Proposed in [Neural Factorization Machines for Sparse Predictive Analytics](https://dl.acm.org/citation.cfm?id=3080777), SIGIR 2017.

* BPRMF
    * Proposed in [BPR: Bayesian Personalized Ranking from Implicit Feedback](https://dl.acm.org/citation.cfm?id=1795167), UAI 2009.
    * Key point: 
        * Replace point-wise with pair-wise.

* ECFKG
    * Proposed in [Learning Heterogeneous Knowledge Base Embeddings for Explainable Recommendation](https://arxiv.org/abs/1805.03352), Algorithms 2018.
    * Implementation by the paper authors: [https://github.com/evison/KBE4ExplainableRecommendation](https://github.com/evison/KBE4ExplainableRecommendation)
    * Key point: 
        * Introduce Knowledge Graph to Collaborative Filtering

* CKE
    * Proposed in [Collaborative Knowledge Base Embedding for Recommender Systems](https://dl.acm.org/citation.cfm?id=2939673), KDD 2016.
    * Key point: 
        * Leveraging structural content, textual content and visual content from the knowledge base.
        * Use TransR which is an approach for heterogeneous network, to represent entities and relations in distinct semantic space bridged by relation-specific matrices.
        * Performing knowledge base embedding and collaborative filtering jointly.

* KGAT
    * Proposed in [KGAT: Knowledge Graph Attention Network for Recommendation](https://arxiv.org/abs/1905.07854), KDD 2019.
    * Implementation by the paper authors: [https://github.com/xiangwang1223/knowledge_graph_attention_network](https://github.com/xiangwang1223/knowledge_graph_attention_network)
    * Key point:
        * Model the high-order relations in collaborative knowledge graph to provide better recommendation with item side information.
        * Train KG part and CF part in turns.
        

## Reproducibility & Example to Run the Codes in tensorflow
To demonstrate the reproducibility of the best performance reported in our paper and faciliate researchers to track whether the model status is consistent with ours, we provide the best parameter settings (might be different for the custormized datasets) in the scripts, and provide [the log for our trainings](https://github.com/xiangwang1223/knowledge_graph_attention_network/tree/master/Log).

The instruction of commands has been clearly stated in the codes (see the parser function in Model/utility/parser.py). 
* Yelp2018 dataset
```
python Main.py --model_type kgat --alg_type bi --dataset yelp2018 --regs [1e-5,1e-5] --layer_size [64,32,16] --embed_size 64 --lr 0.0001 --epoch 1000 --verbose 50 --save_flag 1 --pretrain -1 --batch_size 1024 --node_dropout [0.1] --mess_dropout [0.1,0.1,0.1] --use_att True --use_kge True
```

* Amazon-book dataset
```
python Main.py --model_type kgat --alg_type bi --dataset amazon-book --regs [1e-5,1e-5] --layer_size [64,32,16] --embed_size 64 --lr 0.0001 --epoch 1000 --verbose 50 --save_flag 1 --pretrain -1 --batch_size 1024 --node_dropout [0.1] --mess_dropout [0.1,0.1,0.1] --use_att True --use_kge True
```


* Last-fm dataset
```
python Main.py --model_type kgat --alg_type bi --dataset last-fm --regs [1e-5,1e-5] --layer_size [64,32,16] --embed_size 64 --lr 0.0001 --epoch 1000 --verbose 50 --save_flag 1 --pretrain -1 --batch_size 1024 --node_dropout [0.1] --mess_dropout [0.1,0.1,0.1] --use_att True --use_kge True
```

Some important arguments:
* `model_type`
  * It specifies the type of model.
  * Here we provide six options, including KGAT and five baseline models:
    * `kgat` (by default), proposed in [KGAT: Knowledge Graph Attention Network for Recommendation](https://arxiv.org/abs/1905.07854), KDD2019. Usage: `--model_type kgat`.
    * `bprmf`, proposed in [BPR: Bayesian Personalized Ranking from Implicit Feedback](https://dl.acm.org/citation.cfm?id=1795167), UAI2009. Such model only uses user-item interactions. Usage: `--model_type bprmf`.
    * `fm`, proposed in [Fast context-aware recommendations with factorization machines](https://dl.acm.org/citation.cfm?id=2010002), SIGIR2011. Usage: `--model_type fm`.
    * `nfm`, proposed in [Neural Factorization Machines for Sparse Predictive Analytics](https://dl.acm.org/citation.cfm?id=3080777), SIGIR2017. Usage: `--model_type nfm`.
    * `cke`, proposed in [Collaborative Knowledge Base Embedding for Recommender Systems](https://dl.acm.org/citation.cfm?id=2939673), KDD2016. Usage: `--model_type cke`.
    * `cfkg`, proposed in [Learning Heterogeneous Knowledge Base Embeddings for Explainable Recommendation](https://arxiv.org/abs/1805.03352), Algorithm2018. Usage: `--model_type cfkg`.
  * You can find other baselines, such as RippleNet, MCRec, and GC-MC, in Github.

* `alg_type`
  * It specifies the type of graph convolutional layer.
  * Here we provide three options:
    * `kgat` (by default), proposed in [KGAT: Knowledge Graph Attention Network for Recommendation](xx), KDD2019. Usage: `--alg_type kgat`.
    * `gcn`, proposed in [Semi-Supervised Classification with Graph Convolutional Networks](https://openreview.net/pdf?id=SJU4ayYgl), ICLR2018. Usage: `--alg_type gcn`.
    * `graphsage`, propsed in [Inductive Representation Learning on Large Graphs.](https://papers.nips.cc/paper/6703-inductive-representation-learning-on-large-graphs.pdf), NeurIPS2017. Usage: `--alg_type graphsage`.
    

* `adj_type`
  * It specifies the type of laplacian matrix where each entry defines the decay factor between two connected nodes.
  * Here we provide two options:
    * `si` (by default), where each decay factor between two connected nodes (say, x->y) is set as 1/(out degree of x), while each node is also assigned with 1 for self-connections. Usage: `--adj_type si`.
    * `bi`, where each decay factor between two connected nodes (say, x->y) is set as 1/sqrt((out degree of x)*(out degree of y)). Usage: `--adj_type bi`.
    
* `mess_dropout`
  * It indicates the message dropout ratio, which randomly drops out the outgoing messages. Usage `--mess_dropout [0.1,0.1,0.1]`.
  
* `pretrain`
  * Please note that, as million-scale knowledge graphs are involved in the recommendation task, it is strongly suggested to use the trained user and item embeddings of BPR-MF to initialize the user and item embeddings of all models (including all baselines and our KGAT) by setting the hyperparameter `pretrain` as `-1`.
  * If you would like to train all models from scratch, please set the hyperparameter `pretrain` as `0`. In this case, please set the number of epoch and the criteria of early stopping larger.

## Dataset
We provide three processed datasets: Amazon-book, Last-FM, and Yelp2018.
* You can find the full version of recommendation datasets via [Amazon-book](http://jmcauley.ucsd.edu/data/amazon), [Last-FM](http://www.cp.jku.at/datasets/LFM-1b/), and [Yelp2018](https://www.yelp.com/dataset/challenge).
* We follow [KB4Rec](https://github.com/RUCDM/KB4Rec) to preprocess Amazon-book and Last-FM datasets, mapping items into Freebase entities via title matching if there is a mapping available.

| | | Amazon-book | Last-FM | Yelp2018 |
|:---:|:---|---:|---:|---:|
|User-Item Interaction| #Users | 70,679 | 23,566 | 45,919|
| | #Items | 24,915 | 48,123 | 45,538|
| | #Interactions | 847,733 | 3,034,796 | 1,185,068|
|Knowledge Graph | #Entities | 88,572 | 58,266 | 90,961|
| | #Relations | 39 | 9 | 42 |
| | #Triplets | 2,557,746 | 464,567 | 1,853,704|


* `train.txt`
  * Train file.
  * Each line is a user with her/his positive interactions with items: (`userID` and `a list of itemID`).
  
* `test.txt`
  * Test file (positive instances).
  * Each line is a user with her/his positive interactions with items: (`userID` and `a list of itemID`).
  * Note that here we treat all unobserved interactions as the negative instances when reporting performance.
  
* `user_list.txt`
  * User file.
  * Each line is a triplet (`org_id`, `remap_id`) for one user, where `org_id` and `remap_id` represent the ID of such user in the original and our datasets, respectively.
  
* `item_list.txt`
  * Item file.
  * Each line is a triplet (`org_id`, `remap_id`, `freebase_id`) for one item, where `org_id`, `remap_id`, and `freebase_id` represent the ID of such item in the original, our datasets, and freebase, respectively.
  
* `entity_list.txt`
  * Entity file.
  * Each line is a triplet (`freebase_id`, `remap_id`) for one entity in knowledge graph, where `freebase_id` and `remap_id` represent the ID of such entity in freebase and our datasets, respectively.
  
* `relation_list.txt`
  * Relation file.
  * Each line is a triplet (`freebase_id`, `remap_id`) for one relation in knowledge graph, where `freebase_id` and `remap_id` represent the ID of such relation in freebase and our datasets, respectively.