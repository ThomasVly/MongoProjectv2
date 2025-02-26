// Attendre que MongoDB soit prêt
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function initReplicaSet() {
    print("⏳ Vérification du statut du Replica Set...");

    print("allo allo")
    /*const status = rs.status();
    print("tjrs la?")
    if (status.ok === 1) {
        print("✅ Replica Set déjà initialisé.");
        return;
    }*/

    print("🚀 Initialisation du Replica Set...");
    rs.initiate({
        _id: "rs0",
        members: [
            { _id: 0, host: "mongodb1:27017", priority: 1 }, // PRIMARY forcé
            { _id: 1, host: "mongodb2:27017", priority: 2 }  // Secondaire
        ]
    });

    await sleep(5000); // Pause pour laisser MongoDB appliquer la config

    print("🔍 Vérification de la présence de l’arbitre...");
    const newStatus = rs.status();
    const hasArbiter = newStatus.members.some(member => member.arbiterOnly);

    if (!hasArbiter) {
        print("🚀 Ajout de l’arbitre...");
        db.adminCommand({ setDefaultRWConcern: 1, defaultWriteConcern: { w: "majority" } });
        rs.addArb("mongo-arbiter:27017");
        print("✅ Arbitre ajouté avec succès !");
    } else {
        print("ℹ️ L’arbitre est déjà présent.");
    }

    print("🎉 Configuration du Replica Set terminée !");
}

initReplicaSet();
