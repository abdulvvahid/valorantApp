package com.example.valoranttactics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valoranttactics.adapters.SkillAdapter
import com.example.valoranttactics.databinding.FragmentAgentDetailBinding
import com.example.valoranttactics.model.Agent
import com.example.valoranttactics.model.AgentDetail
import com.example.valoranttactics.model.Skill
import kotlinx.android.synthetic.main.agents_item.*
import kotlinx.android.synthetic.main.fragment_agent_detail.*

class AgentDetailFragment : Fragment() {

    private var bind : FragmentAgentDetailBinding? = null
    private val binding get() = bind!!

    private var newAgentName : String? = null
    private var newAgentImage : Int? = null
    private var newAgentDescription : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentAgentDetailBinding.inflate(inflater,container,false)
        arguments?.let {
            newAgentName = AgentDetailFragmentArgs.fromBundle(it).agentName

            val skillList = textle(newAgentName!!)
            binding.agentDetailName.text = newAgentName

            binding.agentSkills.adapter = SkillAdapter(skillList)
            binding.agentSkills.layoutManager = LinearLayoutManager(activity)
            binding.agentSkills.setHasFixedSize(true)

        }
        return binding.root
    }

    private fun agentDetailListing() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind= null
    }

    private  fun textle(agentName : String): List<Skill>{
        val agentSkills = ArrayList<Skill>()

        when(agentName){
            "Breach" -> {binding.agentDetailImageView.setImageResource(R.drawable.breachdetailimage)
            binding.agentDetailDescription.text = "Breach, the bionic Swede, fires powerful, targeted kinetic blasts to aggressively clear a path through enemy ground. The damage and disruption he inflicts ensures no fight is ever fair.\n" +
                    "\n"
                for (i in 0 until 4){
                val item : Skill = when(i%4){
                    0 -> {
                        Skill(R.drawable.skillq , "FLASHPOINT" , "Cost: 200","EQUIP a blinding charge. FIRE the charge to set fast-acting burst through the wall. The charge detonates to blind all players looking at it.\n" +
                                "\n")
                    }
                    1 -> {
                        Skill(R.drawable.skille , "FAULT LINE" , "Cost: Free ","EQUIP a seismic blast. HOLD FIRE to increase the distance. RELEASE to set off the quake, dazing all players in its zone and in a line up to the zone.\n" +
                                "\n")
                    }
                    2 -> {
                        Skill(R.drawable.skillc , "AFTERSHOCK" , "Cost: 100","EQUIP a fusion charge. FIRE the charge to set a slow-acting burst through the wall. The burst does heavy damage to anyone caught in its area.\n" +
                                "\n")
                    }
                    3 -> {
                        Skill(R.drawable.skillx , "ROLLING THUNDER" , "Cost: 7 Points","EQUIP a seismic charge. FIRE to send a cascading quake through all terrain in a large cone. The quake dazes and knocks up anyone caught in it.\n" +
                                "\n")
                    }else -> {
                        Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                    }
                }
                agentSkills += item
            }

            }
            "Brimstone" -> {binding.agentDetailImageView.setImageResource(R.drawable.brimstonedetailimage)
                binding.agentDetailDescription.text = "Joining from the USA, Brimstone's orbital arsenal ensures his squad always has the advantage. His ability to deliver utility precisely and from a distance make him an unmatched boots-on-the-ground commander.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "INCENDIARY" , "Cost: 300","EQUIP an incendiary grenade launcher. FIRE to launch a grenade that detonates as it comes to a rest on the floor, creating a lingering fire zone that damages players within the zone.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "SKY SMOKE" , "Cost: 100","EQUIP a tactical map. FIRE to set locations where Brimstone’s smoke clouds will land. ALTERNATE FIRE to confirm, launching long-lasting smoke clouds that block vision in the selected area.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "STIM BEACON" , "Cost: 100","EQUIP a stim beacon. FIRE to toss the stim beacon in front of Brimstone. Upon landing, the stim beacon will create a field that grants players RapidFire.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "ORBITAL STRIKE" , "Cost: 6 Points","EQUIP a tactical map. FIRE to launch a lingering orbital strike laser at the selected location, dealing high damage-over-time to players caught in the selected area.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Cyper" -> {binding.agentDetailImageView.setImageResource(R.drawable.cyperdetailimage)
                binding.agentDetailDescription.text = "The Moroccan information broker, Cypher is a one-man surveillance network who keeps tabs on the enemy's every move. No secret is safe. No maneuver goes unseen. Cypher is always watching.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "CYBER CAGE" , "Cost: 100","INSTANTLY toss the cyber cage in front of Cypher. Activate to create a zone that blocks vision and slows enemies who pass through it.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "SPYCAM" , "Cost: Free","EQUIP a spycam. FIRE to place the spycam at the targeted location. RE-USE this ability to take control of the camera’s view. While in control of the camera, FIRE to shoot a marking dart. This dart will reveal the location of any player struck by the dart.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "TRAPWIRE" , "Cost: 200","EQUIP a trapwire. FIRE to place a destructible and covert tripwire at the targeted location creating a line that spans between the placed location and the wall opposite. Enemy players who cross a tripwire will be tethered, revealed, and dazed after a short period if they do not destroy the device in time. This ability can be picked up to be REDEPLOYED.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "NEURAL THEFT" , "Cost: 7 Points","INSTANTLY use on a dead enemy player in your crosshairs to reveal the location of all living enemy players.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Jett" -> {binding.agentDetailImageView.setImageResource(R.drawable.jettdetailimage)
                binding.agentDetailDescription.text = "Representing her home country of South Korea, Jett's agile and evasive fighting style lets her take risks no one else can. She runs circles around every skirmish, cutting enemies before they even know what hit them."
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "UPDRAFT" , "Cost: 100","INSTANTLY propel Jett high into the air.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "TAILWIND" , "Cost: Free","INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "CLOUDBURST" , "Cost: 100","INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "BLADE STORM" , "6 Points","EQUIP a set of highly accurate knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }
            }
            "Omen" -> {binding.agentDetailImageView.setImageResource(R.drawable.omendetailimage)
                binding.agentDetailDescription.text = "A phantom of a memory, Omen hunts in the shadows. He renders enemies blind, teleports across the field, then lets paranoia take hold as his foe scrambles to learn where he might strike next.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "PARANOIA" , "Cost: 200","INSTANTLY fire a shadow projectile forward, briefly reducing the vision range of all players it touches. This projectile can pass straight through walls.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "DARK COVER" , "Cost: Free","EQUIP a shadow orb and see its range indicator. FIRE to throw the shadow orb to the marked location, creating a long-lasting shadow sphere that blocks vision. HOLD ALTERNATE FIRE while targeting to move the marker further away. HOLD the ability key with targeting to move the market closer.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "SHROUDED STEP" , "Cost: 100","EQUIP a shadow walk ability and see its range indicator. FIRE to begin a brief channel, then teleport to the marked location.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "FROM THE SHADOWS" , "7 Points","EQUIP a tactical map. FIRE to begin teleporting to the selected location. While teleporting, Omen will appear as a Shade that can be destroyed by an enemy to cancel his teleport.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Phoenix" -> {binding.agentDetailImageView.setImageResource(R.drawable.phonexdetailimage)
                binding.agentDetailDescription.text = "Hailing from the U.K., Phoenix's star power shines through in his fighting style, igniting the battlefield with flash and flare. Whether he's got backup or not, he'll rush into a fight on his own terms.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "CURVEBALL" , "Cost: 200","EQUIP a flare orb that takes a curving path and detonates shortly after throwing. FIRE to curve the flare orb to the left, detonating and blinding any player who sees the orb. ALTERNATE FIRE to curve the flare orb to the right.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "HOT HANDS" , "Cost: Free","EQUIP a fireball. FIRE to throw a fireball that explodes after a set amount of time or upon hitting the ground, creating a lingering fire zone that damages enemies.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "BLAZE" , "Cost: 200","EQUIP a flame wall. FIRE to create a line of flame that moves forward, creating a wall of fire that blocks vision and damages players passing through it. HOLD FIRE to bend the wall in the direction of your crosshair.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "RUN IT BACK" , "Cost: 6 Points","INSTANTLY place a marker at Phoenix’s location. While this ability is active, dying or allowing the timer to expire will end this ability and bring Phoenix back to this location with full health.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Raze" -> {binding.agentDetailImageView.setImageResource(R.drawable.razedetailimage)
                binding.agentDetailDescription.text = "Raze explodes out of Brazil with her big personality and big guns. With her blunt-force-trauma playstyle, she excels at flushing entrenched enemies and clearing tight spaces with a generous dose of “boom.”\n"

                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "BLAST PACK\n" , "Cost: 200","INSTANTLY throw a Blast Pack that will stick to surfaces. RE-USE the ability after deployment to detonate, damaging and moving anything hit. Raze isn't damaged by this ability, but will still take fall damage if launched up far enough.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "PAINT SHELLS" , "Cost: Free","EQUIP a cluster grenade. FIRE to throw the grenade, which does damage and creates sub-munitions, each doing damage to anyone in their range.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "BOOM BOT" , "Cost: 200","EQUIP a Boom Bot. FIRE will deploy the bot, causing it to travel in a straight line on the ground, bouncing off walls. The Boom Bot will lock on to any enemies in its frontal cone and chase them, exploding for heavy damage if it reaches them.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "SHOWSTOPPER" , "Cost: 6 Point","EQUIP a rocket launcher. FIRE shoots a rocket that does massive area damage on contact with anything.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Cost: Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Reyna" -> {binding.agentDetailImageView.setImageResource(R.drawable.reynadetailimage)
                binding.agentDetailDescription.text = "Forged in the heart of Mexico, Reyna dominates single combat, popping off with each kill she scores. Her capability is only limited by her raw skill, making her highly dependent on performance.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "DEVOUR" , "Cost: 100","Enemies killed by Reyna leave behind Soul Orbs that last 3 seconds. INSTANTLY consume a nearby soul orb, rapidly healing for a short duration. Health gained through this skill exceeding 100 will decay over time. If EMPRESS is active, this skill will automatically cast and not consume the orb.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "DISMISS" , "Cost: 100","INSTANTLY consume a nearby soul orb, becoming intangible for a short duration. If EMPRESS is active, also become invisible.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "LEER" , "Cost: 200","EQUIP an ethereal destructible eye. ACTIVATE to cast the eye a short distance forward. The eye will Nearsight all enemies who look at it.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "EMPRESS" , "Cost: 6 Points","INSTANTLY enter a frenzy, increasing firing speed, equip and reload speed dramatically. Scoring a kill renews the duration.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Sage" -> {binding.agentDetailImageView.setImageResource(R.drawable.sagedetailimage)
                binding.agentDetailDescription.text = "The stronghold of China, Sage creates safety for herself and her team wherever she goes. Able to revive fallen friends and stave off aggressive pushes, she provides a calm center to a hellish fight.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "SLOW ORB" , "Cost: 100","EQUIP a slowing orb. FIRE to throw a slowing orb forward that detonates upon landing, creating a lingering field that slows players caught inside of it.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "HEALING ORB" , "Cost: Free","EQUIP a healing orb. FIRE with your crosshairs over a damaged ally to activate a heal-over-time on them. ALT FIRE while Sage is damaged to activate a self heal-over-time.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "BARRIER ORB" , "Cost: 400","EQUIP a barrier orb. FIRE places a solid wall. ALT FIRE rotates the targeter.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "RESURRECTION" , "Cost: 7 Points","EQUIP a resurrection ability. FIRE with your crosshairs placed over a dead ally to begin resurrecting them. After a brief channel, the ally will be brought back to life with full health.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Sova" -> {binding.agentDetailImageView.setImageResource(R.drawable.sovadetailimage)
                binding.agentDetailDescription.text = "Born from the eternal winter of Russia's tundra, Sova tracks, finds, and eliminates enemies with ruthless efficiency and precision. His custom bow and incredible scouting abilities ensure that even if you run, you cannot hide.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "SHOCK BOLT" , "Cost: 100","EQUIP a bow with a shock bolt. FIRE to send the explosive forward, detonating upon collision and damaging players nearby. HOLD FIRE to extend the range of the projectile. ALTERNATE FIRE to add up to two bounces to this arrow.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "RECON BOLT" , "Cost: Free","EQUIP a bow with a recon bolt. FIRE to send the recon bolt forward, activating upon collision and revealing the location of nearby enemies caught in the line of sight of the bolt. HOLD FIRE to extend the range of the projectile. ALTERNATE FIRE to add up to two bounces to this arrow.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "OWL DRONE" , "Cost: 300","EQUIP an owl drone. FIRE to deploy and take control of movement of the drone. While in control of the drone, FIRE to shoot a marking dart. This dart will reveal the location of any player struck by the dart.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "HUNTER’S FURY" , "Cost: 7 Points","EQUIP a bow with three long-range wall-piercing energy blasts. FIRE to release an energy blast in a line in front of Sova, dealing damage and revealing the location of enemies caught in the line. This ability can be RE-USED up to two more times while the ability timer is active.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }
            "Viper" -> {binding.agentDetailImageView.setImageResource(R.drawable.viperdetailimage)
                binding.agentDetailDescription.text = "The American chemist, Viper deploys an array of poisonous chemical devices to control the battlefield and cripple the enemy's vision. If the toxins don't kill her prey, her mind games surely will.\n" +
                        "\n"
                for (i in 0 until 4){
                    val item : Skill = when(i%4){
                        0 -> {
                            Skill(R.drawable.skillq , "POISON CLOUD" , "Cost: 200","EQUIP a gas emitter. FIRE to throw the emitter that perpetually remains throughout the round. RE-USE the ability to create a toxic gas cloud at the cost of fuel. This ability can be RE-USED more than once and can be picked up to be REDEPLOYED.\n" +
                                    "\n")
                        }
                        1 -> {
                            Skill(R.drawable.skille , "TOXIC SCREEN" , "Cost: Free","EQUIP a gas emitter launcher. FIRE to deploy a long line of gas emitters. RE-USE the ability to create a tall wall of toxic gas at the cost of fuel. This ability can be RE-USED more than once.\n" +
                                    "\n")
                        }
                        2 -> {
                            Skill(R.drawable.skillc , "SNAKE BITE" , "Cost: 100","EQUIP a chemical launcher. FIRE to launch a canister that shatters upon hitting the floor, creating a lingering chemical zone that damages and slows enemies.\n" +
                                    "\n")
                        }
                        3 -> {
                            Skill(R.drawable.skillx , "VIPER’S PIT" , "Cost: 7 Points","EQUIP a chemical sprayer. FIRE to spray a chemical cloud in all directions around Viper, creating a large cloud that reduces the vision range and maximum health of players inside of it.\n" +
                                    "\n")
                        }else -> {
                            Skill(R.drawable.skillc , "Breach" , "Initiator","asşd")
                        }
                    }
                    agentSkills += item
                }

            }

        }
        return agentSkills
    }

}