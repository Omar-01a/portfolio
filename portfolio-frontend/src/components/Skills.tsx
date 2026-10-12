function Skills() {

  const skillGroups = [
    {
      title: "Backend",
      skills: ["Java", "Spring Boot", "REST API"]
    },
    {
      title: "Database & API",
      skills: ["PostgreSQL", "REST API"]
    },
    {
      title: "Tools & Cloud",
      skills: ["Git", "Docker", "AWS"]
    },
    {
      title:"Languages", 
      skills: ["Java", "Python", "C++", "Dart", "SQL"]
    }
  ]

  return (
    <section
      id="skills"
      className="border-t border-white/10 px-6 py-24 md:py-32"
    >

      <div className="mx-auto max-w-6xl">

        {/* Section Header */}

        <p className="mb-3 text-sm font-medium uppercase tracking-[0.35em] text-gray-500">
          Skills
        </p>

        <h2 className="text-4xl font-bold tracking-tight md:text-5xl">
          Technologies I work with.
        </h2>


        {/* Skill Groups */}

        <div className="mt-14 grid gap-6 md:grid-cols-3">

          {skillGroups.map((group) => (

            <div
              key={group.title}
              className="rounded-2xl border border-white/10 bg-white/[0.03] p-6 transition hover:-translate-y-1 hover:border-white/20 hover:bg-white/[0.05]"
            >

              {/* Group Title */}

              <h3 className="text-xl font-bold">
                {group.title}
              </h3>


              {/* Skills */}

              <div className="mt-6 flex flex-wrap gap-3">

                {group.skills.map((skill) => (

                  <span
                    key={skill}
                    className="rounded-lg border border-white/10 bg-black/30 px-3 py-2 text-sm text-gray-400 transition hover:text-white"
                  >
                    {skill}
                  </span>

                ))}

              </div>

            </div>

          ))}

        </div>

      </div>

    </section>
  )
}

export default Skills