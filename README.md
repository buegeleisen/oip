# Solution from group JA.COM for oip

Implementation des genetischen Algorithmus für: https://hub.docker.com/r/jreichwald/dhbw_oip/

Der Code muss in Eclipse als Maven Projekt importiert werden. Im Anschluss muss die Main-Methode der Main-Klasse gestartet werden.

Infos zum Starten:
**im docker-compose.yml muss unter environment "DELAY: 1" ergänzt werden.**

```
environment:
      RHOST: mq
      FTYPE: 4
      DELAY: 1
```



Bester Vektor:
```
{
    "solutionCandidateId": "captured",
    "solutionVector": [
          -2.9883899123337234,
          -3.4615617161852166,
          -2.7924103827435776,
          2.1974011296671407,
          -2.777220477239749,
          -2.9984579100269197,
          -2.835116984633576,
          -2.191915543432801,
          -2.845613157832519,
          -2.7474811128576655,
          -2.689651186777686,
          3.001537836922715,
          2.261869898385324,
          2.135746662849333,
          -2.7298153370965292,
          -2.9519591744797253,
          -2.4928637358709436
    ],
    "resultValue": -579.2352715521621,
    "isFeasible": true,
    "isEvaluated": true
}
```
