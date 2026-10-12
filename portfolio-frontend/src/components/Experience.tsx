import { useEffect, useState } from "react"
import type { Experience as ExperienceType } from "../types/Experience"

function Experience() {

  const [experiences, setExperiences] = useState<ExperienceType[]>([])

  useEffect(() => {

    fetch("http://localhost:8080/api/experiences")
      .then((response) => response.json())
      .then((data: ExperienceType[]) => {
        setExperiences(data)
      })

  }, [])

  return (
    <section id="experience" className="px-6 py-24">

      <div className="mx-auto max-w-6xl">

        <p className="mb-3 text-sm uppercase tracking-[0.3em] text-gray-500">
          Experience
        </p>

        <h2 className="text-4xl font-bold md:text-5xl">
          Where I've worked.
        </h2>

        <div className="mt-12 space-y-6">

          {experiences.map((experience) => (

            <article
              key={experience.id}
              className="rounded-2xl border border-white/10 bg-white/[0.03] p-6"
            >

              <div className="flex flex-col justify-between gap-2 md:flex-row">

                <div>

                  <h3 className="text-2xl font-bold">
                    {experience.position}
                  </h3>

                  <p className="mt-1 text-gray-400">
                    {experience.company}
                  </p>

                </div>

                <div className="text-sm text-gray-500 md:text-right">

                  <p>
                    {experience.startDate} - {experience.endDate}
                  </p>

                  <p className="mt-1">
                    {experience.location}
                  </p>

                </div>

              </div>

              <p className="mt-6 leading-7 text-gray-400">
                {experience.description}
              </p>

            </article>

          ))}

        </div>

      </div>

    </section>
  )
}

export default Experience