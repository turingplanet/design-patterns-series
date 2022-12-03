
class BadCharacterSkill:
    def basicAttack(self): pass

class AdvancedBadCharacterSkill:
    def magicAttack(self): pass
    def recover(self): pass

class Monster(BadCharacterSkill):
    def basicAttack(self): 
        print('monster basic attack')

class MonsterBoss(BadCharacterSkill, AdvancedBadCharacterSkill):
    def basicAttack(self): 
        print('monsterboss basic attack')

    def magicAttack(self): 
        print('monsterboss magic attack')

    def recover(self): 
        print('monsterboss recover')

m = Monster()
m.basicAttack()

mb = MonsterBoss()
mb.magicAttack()
